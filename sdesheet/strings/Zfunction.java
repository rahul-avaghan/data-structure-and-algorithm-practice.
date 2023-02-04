import java.util.Arrays;

public class Zfunction {

    /***
     * Z function is an array consisting of length of the prefix starting at given
     * position
     * 
     * For example : []
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {

        char[] str = "ababb".toCharArray();
        int[] zfunction = new int[10];
        Arrays.fill(zfunction, 0);
        for (int left = 1; left < str.length; left++) {
            for (int right = left; right < str.length; right++) {
                if (str[right - 1] == str[right]) {
                    zfunction[left]++;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(zfunction));

    }
}
