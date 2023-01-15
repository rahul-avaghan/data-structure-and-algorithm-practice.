import java.util.Arrays;

public class sortOnesAndZeros {

    public static void main(String[] args) {

        int[] input = { 2, 1, 2, 0, 1, 2, 1, 1, 1, 2, 2, 2, 1 };
        sort(input);
        System.out.println(Arrays.toString(input));
    }

    public static void sort(int[] input) {

        int low = 0, high = input.length - 1, mid = 0;

        while (mid <= high) {

            switch (input[mid]) {
                case 0:
                    swap(input, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(input, mid, high);
                    high--;
                    break;
            }

        }

    }

    private static void swap(int[] number, int start, int end) {

        int temp = number[start];
        number[start] = number[end];
        number[end] = temp;
    }

}
