import java.util.HashMap;

public class LongestsubstringWithoutRepeatation {

    public static void main(String[] args) {

        Character[] input = { 'a', 'b', 'c', 'a', 'b', 'c', 'd' };

        var map = new HashMap<Character, Integer>();
        int left = 0, right = 0, max = 0;

        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                left = map.get(input[i]) + 1;

            }
            map.put(input[i], i);
            max = Math.max(max, right - left + 1);
            right++;
        }

        System.out.println("Longest string " + max);
    }

}
