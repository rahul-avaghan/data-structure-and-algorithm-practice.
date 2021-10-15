public class Palindrome {
    
    public static void main(String[] args) {
            System.out.println(palindrome("KAYAK"));
            System.out.println(palindrome("asdfasdf"));
    }

    public static Boolean palindrome(String input){
        if(input.length() == 0 || input.length() == 1){
            return true;
        }
        
        if(input.charAt(0) == input.charAt(input.length() - 1)){
            return palindrome(input.substring(1, input.length() - 1));
        }
        return false;
    }
}
