import java.util.HashMap;

/***
 * 
 * 
 * Problem Statement: Given an array containing both positive and negative integers, we have to find the length 
 * of the longest subarray with the sum of all elements equal to zero.
 * 
 * Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}
 * Result: 5
 * Explanation: The following subarrays sum to zero:
 * {-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
 * Since we require the length of the longest subarray, our answer is  5!
 * 
 * 
 * Time complexity O(N)
 */
public class LongestSubArrayWithSumZero {
    public static void main(String[] args) {
        int[] input = { 1, -1, 1, 3, 2, -1, -8, -1 };

        int sum = Integer.MIN_VALUE;
        int maxlength = 0;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (sum == 0) {
                maxlength = i + 1;
            } else if (map.containsKey(sum)) {
                maxlength = Math.max(maxlength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
    }
}