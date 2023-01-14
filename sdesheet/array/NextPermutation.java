import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[][] numbers = {
                // 1,678,756
                { 1, 6, 7, 8, 7, 5, 6 },
                { 1, 2, 5, 6, 5, 3, 2 }
        };

        for (int[] number : numbers) {
            System.out.println("Input " + format(number));
            System.out.println(format(nextPermutation(number)));
        }

    }

    private static int[] nextPermutation(int[] number) {

        if (number.length < 1) {
            return number;
        }

        int lastPeak = -1;
        int index = 1;

        while (index < number.length) {
            if (number[index] > number[index - 1]) {
                lastPeak = index;
            }
            index++;
        }

        if (lastPeak == -1) {
            for (int i = 0; i < number.length / 2; i++)
                swap(number, i, number.length - i);
        }

        int foundMaximum = lastPeak;
        int peakValue = number[lastPeak];
        int minimumIndex = lastPeak - 1;
        int minimum = number[lastPeak - 1];

        for (int i = foundMaximum; i < number.length; i++) {
            int currentValue = number[i];
            if (currentValue > minimum && currentValue < peakValue) {
                foundMaximum = i;
            }
        }
        swap(number, minimumIndex, foundMaximum);
        Arrays.sort(number, lastPeak + 1, number.length);

        return number;
    }

    private static void swap(int[] number, int start, int end) {

        int temp = number[start];
        number[start] = number[end];
        number[end] = temp;
    }

    private static String format(int[] number) {
        String[] strArray = Arrays.stream(number)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        return String.join("", strArray);
    }
}
