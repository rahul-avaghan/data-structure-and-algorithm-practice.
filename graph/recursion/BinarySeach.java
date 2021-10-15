import java.util.Arrays;

public class BinarySeach {

    public static void main(String[] args) {

        int[] input = { 1, 2, 4, 5, 6, 7 , 9};
        System.out.println(binarySearch(input, 100, 0, input.length - 1));
        System.out.println(Arrays.toString(input));

    }

    private static boolean binarySearch(int[] input, int searchTerm, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;

        if (searchTerm == input[mid]) {
            return true;

        }

        if (searchTerm > input[mid]) {
            return binarySearch(input, searchTerm, mid + 1, right);
        }
        return binarySearch(input, searchTerm, left, mid - 1);

    }
}
