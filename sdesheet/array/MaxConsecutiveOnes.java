public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] input = new int[] { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 };

        System.out.println("max number " + countOnes(input));

    }

    // 1,1,1,1,1,1,0,0,0,0,0
    private static int countOnes(int[] input) {

        int max = 0, tempMax = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 1) {
                max = Math.max(max, tempMax);
                tempMax = 0;
                continue;
            }
            tempMax++;
        }

        return max;

    }
}
