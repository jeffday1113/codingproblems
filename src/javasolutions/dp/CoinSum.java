package javasolutions.dp;

public class CoinSum {
    
    /* -Dynamic Programming problem (Recurrent formula and some sort of starting state)
     * -Sub solution of the problem is constructed from previously found ones
     * -ALWAYS POLYNOMIAL COMPLEXITY 
     * 
     * PROBLEM STATEMENT: N coins with value (V1, V2, ..., Vn) and a total sum of S
     * FIND: Min number of coins to sum to S or say that a solution does not exist
     * 
     * STATE: the solution for sum i where i<= S
     * -For each coin j where Vj <= i, look at the min number of coins found for the i-Vj sum
     * 
     * Start by looking at the sum 0, there is a solution with 0 coins
     * Then the sum 1, only the coin 1 is less than or equal to the sum of 1. So we look at the min
     * coins solution for the sum 1 minus the value of the coin value 1, which is 0. That value plus
     * one is less than infinity, so that is the new min*/
    
    
    public static void main(String[] args) {
        int[] coinVals = {1, 2};
        System.out.println(coinSumDP(coinVals, 2));
    }
    
    public static int coinSumDP(int[] coinVals, int sum) {
        if (sum < 0) {
            return -1;
        } else if (sum == 0) {
            return 0;
        } else {
            /* Create an array to hold the min values for values from 0 to the desired sum */
            int[] minVals = new int[sum + 1];
            /* Set the values to infinity (big number) */
            for (int j = 0; j < minVals.length; j++) {
                minVals[j] =  2147483647;
            }
            /* Trivial solution, The minimum number of coins necessary to have a sum of 0 is 0 */
            minVals[0] = 0;
            /* Loop through all sums from 1 to the desired sum */
            for (int i = 1; i <= sum; i++) { // i = 1
                /* For each sum examine all the possible coin values */
                for (int k = 0; k < coinVals.length; k++) { // k = 0
                    /* If the coin value is less than the current sum being examined and if you add
                     * one to the minimum number of moves for the sum minus the current value plus 
                     * one, then we know that this is the new minimum number of coins needed */
                    if (coinVals[k] <= i && minVals[i-coinVals[k]] + 1 < minVals[i]) {
                        minVals[i] = minVals[i-coinVals[k]] + 1;
                    }
                }
            }
            return minVals[sum];
        }
    }

}
