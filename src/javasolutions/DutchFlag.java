package javasolutions;

public class DutchFlag {
    public static void main(String[] args) {
        DutchFlag df = new DutchFlag();
        int[] array = {0, -4, 3, -7, 0, 2, 6, -10, -9, 7};
        array = df.rearrangePosAndNeg(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    /* Go through numbers left to right, if number 
     * is less than 0, switch it with the less than mid
     * boundary. if it is greater than 0, switch with */
    public int[] rearrangePosAndNeg(int[] nums) {
        /* boundary for numbers less than mid */
        int i = 0;
        /* current number under consideration */
        int j = 0;
        /* n is boundary of numbers greater than mid */
        int n = nums.length - 1;
        int counter = 0;
        while (j <= n) {
            if (nums[j] < 0) {
                nums = swap(nums, i, j);
                i++;
                j++;
            }
            else if (nums[j] > 0) {
                nums = swap(nums, j, n);
                n--;
            }
            else {
                j++;
            }
            counter++;
        }
        System.out.println(counter);
        return nums;
    }

    private int[] swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
