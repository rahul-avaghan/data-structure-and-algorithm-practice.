import java.util.ArrayList;

public class ReversePairs {

    public static void main(String[] args) {
        int input[] = { 1, 3, 2, 3, 1 };

        System.out.println("Reverse pair count: " + mergeSort(input, 0, input.length - 1));

    }

    public static int mergeSort(int[] input, int low, int high) {

        int inv = 0;

        if (low >= high) {
            return 0;
        }

        int mid = (low + high) / 2;

        inv = mergeSort(input, low, mid);
        inv += mergeSort(input, mid + 1, high);

        inv += merge(input, low, mid, high);
        return inv;
    }

    public static int merge(int[] input, int low, int mid, int high) {

        // [40,25,19,12,9,6,2]
        // [40] [25]
        // low = 0 high = 1
        int j = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {
            while (j <= high && input[i] > 2 * input[j]) {
                j++;

            }
            count += j - (mid + 1);
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {

            if (input[left] <= input[right]) {
                temp.add(input[left++]);

            } else {
                temp.add(input[right++]);
            }
        }
        while (left <= mid) {
            temp.add(input[left++]);
        }

        while (right <= high) {
            temp.add(input[right++]);
        }

        for (int i = low; i <= high; i++) {
            // low = 2 high = 4
            // 2,3,4 -> 0,1,2
            // because the temp will have indexes starting from zero.
            // however we have to alter the array starting from low position
            // we will start from low and end at high
            input[i] = temp.get(i - low);
        }

        return count;
    }
}
