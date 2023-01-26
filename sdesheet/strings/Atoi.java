import java.util.HashMap;

/***
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
 * signed integer (similar to C/C++'s atoi function).
 * 
 * The algorithm for myAtoi(string s) is as follows:
 * 
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-'
 * or '+'. Read this character in if it is either. This determines if the final
 * result is negative or positive respectively. Assume the result is positive if
 * neither is present.
 * Read in next the characters until the next non-digit character or the end of
 * the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no
 * digits were read, then the integer is 0. Change the sign as necessary (from
 * step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
 * then clamp the integer so that it remains in the range. Specifically,
 * integers less than -231 should be clamped to -231, and integers greater than
 * 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * 
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of
 * the string after the digits.
 * 
 * 
 * 
 * 
 */

public class Atoi {

    public static void main(String[] args) {

        char[] str = "           123123".toCharArray();
        /***
         * Remove white space
         * check for +/- symobols
         * check for numbers between 0-9
         * check for int bounds
         */
        int i = 0, res = 0, negative = 1, len = str.length;
        while (i < len && str[i] != ' ') {
            i++;
        }

        if (str[i] == '-') {
            i++;
            negative = -1;
        } else {
            i++;
        }

        var map = new HashMap<>();
        int j = i;
        while (j < len) {

            map.put(str[j], j);
            j++;
        }
        while (i < len && map.containsKey(str[i])) {
            res = res * 10 + str[i];
            i++;
        }
        res = res * negative;

        if (res < 0) {
            res = Math.max(res, Integer.MIN_VALUE);
        } else {
            res = Math.min(res, Integer.MAX_VALUE);
        }
    }

}
