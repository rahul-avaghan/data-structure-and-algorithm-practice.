import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] input = { 2, 5, 6, 7, 1, 8 };
        System.out.print(Arrays.toString(input));
        quickSort(0, input.length - 1, input);
        System.out.print(Arrays.toString(input));
    }

    private static void quickSort(int low, int high, int[] array) {

        if (low < high) {
            int j = partition(low, high, array);
            quickSort(low, j, array);
            quickSort(j + 1, high, array);
        }

    }

    private static int partition(int low, int high, int[] array) {

        int pivot = array[low];
        int i = low, j = high;

        while (i < j) {// until unsorted

            // increment until the found value is lesser than pivot.
            // or increment until you find value greater than the pivot.
            do {
                i++;
                System.out.print("i" +  i + " ");
            } while (array[i] <= pivot);
            // decrement until the found value is greater than pivot.
            // or decrement until you find value lesser than the pivot.

            do {
                j--;
                System.out.print("j" + j + " ");

            } while (array[j] > pivot);
            // exchange the values as they belong to other part of partition.
            if (i < j) {
                swap(i, j, array);
            }
        }
        System.out.println("won"+ j);
        swap(j, low, array);
        return j;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
