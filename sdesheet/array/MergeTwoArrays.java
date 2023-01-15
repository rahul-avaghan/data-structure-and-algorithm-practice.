import java.util.Arrays;

public class MergeTwoArrays {

    public static void main(String[] args) {
        int arr1[] = { 1, 4, 7, 8, 10 };
        int arr2[] = { 2, 3, 9 };
        merge(arr1, arr2);
        System.out.println(Arrays.toString(arr1)+ Arrays.toString(arr2));
    }

    private static void merge(int[] first, int[] second) {
        for (int i = 0; i < first.length; i++) {

            if (first[i] > second[0]) {
                var temp = second[0];
                second[0] = first[i];
                first[i] = temp;
            }
        }

        var firstItem = second[0];
        int k;
        for (k = 1; k < second.length && second[k] < firstItem; k++) {
            second[k - 1] = second[k];
        }
        second[k - 1] = firstItem;
    }
}
