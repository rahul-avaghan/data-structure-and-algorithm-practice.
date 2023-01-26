import java.util.Arrays;

public class LongestCommonPrefix {

    /***
     * 
     * Write a function to find the longest common prefix string amongst an array of
     * strings.
     * 
     * If there is no common prefix, return an empty string "".
     * 
     * @param args
     */
    public static void main(String[] args) {

        String[] strs = { "flower", "flow", "flight" };

        StringBuilder prefix = new StringBuilder();
        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        for (int i = 0; i < strs.length; i++) {
            if (first[i] != last[i]) {
                break;
            }
            prefix.append(first[i]);

        }

        System.out.println(" Common prefix is " + prefix.toString());

    }
}