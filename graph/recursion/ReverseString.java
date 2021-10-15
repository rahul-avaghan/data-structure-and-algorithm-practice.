public class ReverseString {

    public static void main(String[] args) {
        System.out.println(ReverseString.reverseString("aba"));
    }

    private static String reverseString(String input) {
        if (input.equals(""))
            return "";
        return reverseString(input.substring(1, input.length())) + input.charAt(0);

    }
}