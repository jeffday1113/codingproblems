package javasolutions.sorting;

public class Mergesort {
    
    public static void main(String[] args) {
        int[] array = {1, 7, 3, 9, 12, 5, 8, 2};
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    public static void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(nums, temp, left, center);
            mergeSort(nums, temp, center + 1, right);
            merge(nums, temp, left, center, right);
        }
    }
    
    public static void merge(int[] nums, int[] temp, int left, int middle, int right) {
        /* Copy over the nums array to the temp array */
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        
        /* Have a temp value for the beginning of the left (far left), beginning of the right
         * (one past the middle), and the current one examining. Make a sweep through the whole
         * array until we have examined all of one side */
        int tempLeft = left;
        int tempRight = middle + 1;
        int current = left;
        while (tempLeft <= middle && tempRight <= right) {
            if (temp[tempLeft] <= temp[tempRight]) {
                nums[current] = temp[tempLeft];
                tempLeft++;
            } else {
                nums[current] = temp[tempRight];
                tempRight++;
            }
            current++;
        }
        
        /* Only need to copy the remaining left hand side over. This is because both subarrays
         * being merged are sorted. So if we get through all of the numbers of the left hand side,
         * we know that all of the numbers on the left hand side were less than the number on the
         * right hand side that we were examining. At this point, we know the rest of the right
         * side is sorted so we are done*/
        int leftRemaining = middle - tempLeft;
        for (int i = 0; i <= leftRemaining; i++) {
            nums[current + i] = temp[tempLeft + i];
        }
    }

}
