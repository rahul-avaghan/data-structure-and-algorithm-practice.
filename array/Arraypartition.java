public class Arraypartition {

    public static void main(String[] args) {

        int input[] = { 1, 2, 3, 3, 4 };

        int n = input.length;

        int i = 0, j = n;
        int a = 1, b = 2;

        while (i < j) {
            if (input[i] < a) {
                swap(input, input[i], a);
                i++;
            } else if (input[i] > b) {
                swap(input, input[i], b);
                j--;
            } else {
                i++;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
