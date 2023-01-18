import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int input[] = { 1, 4, 7, 8, 10 };
        System.out.println(Arrays.toString(twoSum(input, 11)));
        ;
    }

    private static int[] twoSum(int[] input, int sum) {

        var map = new HashMap<>();
        // 14
        for (int i = 0; i < input.length; i++) {

            if (map.get(sum - input[i]) != null) {
                int[] temp = new int[2];
                temp[0] = input[i];
                temp[1] = sum - input[i];
                return temp;

            }
            map.put(input[i], i);
        }
        return new int[0];

    }

}
