public class kthLargest {

    public static void main(String[] args) {
        int[] array = { 1, 2, 5, 4, 3 };
        int k = 3;
        System.out.println(kthIndex(0, array.length - 1, k, array));
    }

    private static int kthIndex(int low, int high, int k, int[] array) {

        while (low <= high) {
            int pivot = partition(low, high, array);
            if (pivot == k - 1) {
                return array[pivot];
            } else if (pivot > k - 1) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return -1;

    }

    private static int partition(int low, int high, int[] array) {

        int pivot = array[low];
        int i = low, j = high;

        while (i < j) {// until unsorted

            // increment until the found value is lesser than pivot.
            // or increment until you find value greater than the pivot.
            do {
                i++;
            } while (array[i] <= pivot && i < array.length -1);
            // decrement until the found value is greater than pivot.
            // or decrement until you find value lesser than the pivot.

            do {
                j--;
            } while (array[j] > pivot && j > 0);
            // exchange the values as they belong to other part of partition.
            if (i < j) {
                swap(i, j, array);
            }
        }
        swap(j, low, array);
        return j;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
