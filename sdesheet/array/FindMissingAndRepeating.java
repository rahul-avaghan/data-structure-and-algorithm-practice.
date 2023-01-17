public class FindMissingAndRepeating {


    public static void main(String[] args) {

        int[] input = { 3, 1, 2, 5, 3 };
        findMissingAndRepeatingNumber(input);
    }

    public static void findMissingAndRepeatingNumber(int[] input) {

        int x = 0, y = 0, xo1 = input[0];
        int length = input.length;

        for (int i = 1; i < length; i++) {

            xo1 ^= input[i];
        }

        for (int i = 1; i <= length; i++) {
            xo1 ^= i;
        }
        int setbit = xo1 & ~(xo1 - 1);

        for (int i = 0; i < length; i++) {

            if ((input[i] & setbit) != 0) {
                x ^= input[i];
            } else {
                y ^= input[i];
            }
        }

        for (int i = 1; i <= length; i++) {

            if ((i & setbit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        System.out.println("Missing and repeating number " + x + " " + y);
    }
}
