public class FindGivenNumber {

    public static void main(String[] args) {

        int[][] input = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int number = 8;
        System.out.print("Given number is  " + number + " " + findGivenNumber(input, number));
    }

    private static boolean findGivenNumber(int[][] input, int number) {

        int low = 0, high = input.length * input[0].length - 1,
                mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            int midValue = input[mid / input.length][mid % input.length];

            if (midValue == number) {
                return true;
            }
            if (number < midValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return false;

    }
}
