import java.util.ArrayList;
import java.util.Arrays;

public class SumZeroTriplets {

    public static void main(String[] args) {

    }

    public static ArrayList<Integer[]> sumZeroBruteForce(int[] input) {

        int length = input.length;
        ArrayList<Integer[]> numbers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (input[i] + input[j] + input[k] == 0) {
                        numbers.add(new Integer[] { input[i], input[j], input[k] });
                    }
                }
            }
        }
        return numbers;
    }

    public static ArrayList<Integer[]> sumZeroOptimised(int[] input) {

        int length = input.length;
        ArrayList<Integer[]> numbers = new ArrayList<>();
        Arrays.sort(input);

        for (int i = 0; i < length; i++) {

            if (i == 0 || (i > 0 && input[i] != input[i - 1])) {
                int low = input[i], high = input[length - 1], remainingSum = 0 - input[i];

                while (low < high) {
                    if (remainingSum == input[low] + input[high]) {
                        numbers.add(new Integer[] { input[i], input[low], input[high] });
                        low++;
                        high--;
                    } else if (remainingSum < input[low] + input[high]) {
                        high--;
                    }
                }
            }
        }

        return numbers;

    }
}
