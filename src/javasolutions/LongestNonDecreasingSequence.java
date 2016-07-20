package javasolutions;

public class LongestNonDecreasingSequence {

    /* Given a sequence of numbers, find longest non decreasing sequence
     * -USE A RECURRENCE RELATION
     * 
     * -STATE: i represents the longest non decreasing sequence whose last number is A[i] */

    public static void main(String[] args) {
        int[] array = {12, 19, 5, 23, 99, 64, 32, 50, 33};
        System.out.println(findLongestNonDecreasingSeq(array));
    }

    /* O(N^2) solution */
    public static int findLongestNonDecreasingSeq(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            int[] state = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                state[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && state[j] + 1 > state[i]) {
                        state[i] = state[j] + 1;
                    }
                }
            }
            return state[state.length-1];
        }
    }

}
