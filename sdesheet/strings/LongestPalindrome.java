public class LongestPalindrome {

    public static void main(String[] args) {

        System.out.println(findLongestPalindrome("baaabbcbbkkkb")); ;

        // int left, right;
        // int maxLength = 0;
        // int length = s.length();

        // for (int i = 0; i < length; i++) {
        // left = i;
        // right = length - 1;
        // String palindrome = "";
        // while (left <= right) {

        // if (s.charAt(left) == s.charAt(right)) {
        // palindrome += s.charAt(left) + "";
        // left++;
        // right--;
        // } else {
        // right--;
        // }
        // }
        // maxLength = Math.max(maxLength, 2 * palindrome.length() - 1);
        // }

        // System.out.println("Length of palindrome " + maxLength);
    }

    /***
     * 
     * abcba
     *
     * c
     * b (ab) b(ab)
     * a a
     *
     *
     * @param args
     */

    public static String findLongestPalindrome(String s) {


        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // for odd
            int l1 = expandFromCenter(s, i, i);
            // for even
            int l2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(l1, l2);

            boolean isLargerThanPreviousOne = len > (end - start);
            if (isLargerThanPreviousOne) {

                // new start`a
                // i will be in the middle of the palindrome
                // len = 3 -> i = 1 len = 3 start = 1 -(3 -1)/2
                // end = 1 + 3/2
                start = i - (len - 1) / 2;
                end = i + len / 2;

            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandFromCenter(String s, int left, int right) {

        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
