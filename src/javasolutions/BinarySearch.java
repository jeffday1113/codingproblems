package javasolutions;

public class BinarySearch {
    /* -Look for element x in a sorted array by comparing x to the midpoint
     * -If less, search left half, if right search right half */
    
    public static void main(String[] args) { 
        int[] array = {1, 4, 55, 77, 96, 100};
        System.out.println(binarySearch(array, 77));
    }
    
    /** Binary Search Iterative
     * 
     */
    
    public static int binarySearch(int[] array, int value) {
        int lowIndex = 0;
        int highIndex = array.length - 1;
        int midIndex;
        while (lowIndex <= highIndex) {
            midIndex = (lowIndex + highIndex) / 2;
            if (array[midIndex] < value) {
                lowIndex = midIndex + 1;
            } else if (array[midIndex] > value) {
                highIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }
    
    /** Binary Search Recursive
     * 
     * @param  array Sorted array of integers
     * @param  value The value we are searching for in the array
     * @param  lowIndex The index of the beginning of the part of the array we are searching
     * @param  highIndex The index of the end of the part of the array we are searching
     * @return The index of where the value we are searching for is in the array, -1 if 
     */
    
    public static int binarySearchRecursive(int[] array, int value, int lowIndex, int highIndex) {
        /* If low index is not less than the high index, then there is something wrong, return an
         * error */
        if (lowIndex > highIndex) {
            return -1;
        }
        /* Calculate the middle index of what ever part of the array we are searching */
        int midIndex = (lowIndex + highIndex) / 2;
        /* If the value at the midIndex is less than the value we are searching for, perform the
         * binary search on the right part of the array. If it is greater than the value we are
         * looking for, perform binary search on the left part of the array. Otherwise, we have
         * found the value and we should return the midIndex */
        if (array[midIndex] > value) {
            return binarySearchRecursive(array, value, lowIndex, midIndex - 1);
        } else if (array[midIndex] < value) {
            return binarySearchRecursive(array, value, midIndex + 1, highIndex);
        } else {
            return midIndex;
        }
    }
}
