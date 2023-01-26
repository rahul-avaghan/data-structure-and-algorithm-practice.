import java.util.ArrayList;
import java.util.Stack;

public class ReverseWords {

    private static char SPACE = ' ';

    public static void main(String[] args) {
        String s = "Google is great for interview preparation";
        reverseWordsBruteForce(s);
        reverseWordsBruteForce(s);

    }

    // Complexity O(n) Space complexity O() 
    private static void reverseWordsBruteForce(String sentence) {

        Stack<String> stack = new Stack<>();

        var currentWord = "";
        for (Character character : sentence.toCharArray()) {

            boolean isSpace = character == SPACE;
            if (isSpace) {
                stack.push(currentWord);
                currentWord = "";
            } else {
                currentWord += character;
            }
        }
        String answer = "";
        while (stack.isEmpty()) {
            answer += stack.peek() + " ";
            stack.pop();
        }

        System.out.println("reveresed sentence is " + answer);

    }
}
