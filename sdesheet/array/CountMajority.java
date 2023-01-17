public class CountMajority {

    public static void main(String[] args) {

        int[] input = { 2, 3, 3, 2, 2, 2, 2 };

        System.out.println("Majority item is : " + countMajority(input));
    }

    private static int countMajority(int[] input) {

        int candidate = 0, count = 0;

        for (int n : input) {

            if (count == 0) {
                candidate = n;
            }

            if (n == candidate) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return candidate;

    }
}
