import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {

        int[] input = { 1, 2, 3, 4, 5, 6,7 };
        int length = input.length-1;
        for (int i = 0; i <= (length/2) ; i++) {
            int temp  = input[i];
            input[i]  = input[length - i];
            input[length - i]  = temp;
        }
        int start = 0;
        int end = length;
        while(start < end){
            int temp  = input[start];
            input[start]  = input[end];
            input[end]  = temp;
            start++;
            end--;
        }

        System.out.print(Arrays.toString(input));
    }

}

// 2 -> 1
// 3 -> 1
// 4 --> 2
// 5 --> 2
// 6 --> 3



