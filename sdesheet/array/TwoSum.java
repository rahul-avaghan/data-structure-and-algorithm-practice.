import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int input[] = { 1, 4, 7, 8, 10 };
        System.out.println(Arrays.toString(twoSum(input, 15)));
        System.out.println(Arrays.toString(twoPointerApproach(input, 15)));

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

    // 11
    private static int[] twoPointerApproach(int[] input, int sum) {
        // This is applicable for a sorted array
        int low = 0, high = input.length - 1;
        // 2,3,4,5,6,7
        while (low < high) {

            if (input[low] + input[high] == sum) {
                return new int[] { input[low], input[high] };
            }

            var difference = sum - input[low];
            // else if(store[left]+store[right]>target)

            if (difference < input[high]) {
                high--;
            } else {
                low++;
            }

        }
        return new int[] {};
    }

}
