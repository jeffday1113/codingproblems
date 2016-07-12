package javasolutions;

public class QuickSort {
    
    public static void main(String[] args) {
        int[] array = {3, 4, 1, 8, 4, 99, 10, 3};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    public static void quickSort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        /* partition function returns the end point of the left index. Because it return the left
         * index, need to perform quicksort at beginning to one less of index , and also the index
         * to the right*/
        if (left < index - 1) {
            quickSort(array, left, index - 1);
        }
        if (index < right) {
            quickSort(array, index, right);
        }
    }
    
    public static int partition(int[] array, int left, int right) {
        /* Choose the pivot as the middle element in the array, this is what we will be comparing
         * number against */
        int pivot = array[(left + right) / 2];
        while (left <= right) {
            /* Move left index to a number that is greater than the pivot (is on the wrong side of
             * the array) */
            while (array[left] < pivot) {
                left++;
            }
            /* Move right index to a number that is less than the pivot (is on the wrong side of
             * the array) */
            while (array[right] > pivot) {
                right--;
            }
            
            /* If the left index is less than the right index, switch the numbers (a number greater 
             * than the pivot gets moved to the right of the pivot, a number less than the pivot 
             * gets moved to the left of the pivot) and then move each index one */
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
            /* Do this again if left is less than or equal to right (still more numbers to examine)
             *  */
        }
        return left;
    }
    
    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
