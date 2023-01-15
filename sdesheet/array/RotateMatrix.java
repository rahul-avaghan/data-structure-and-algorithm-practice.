import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] input = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        rotateBy90(input);
    }

    private static void rotateBy90(int[][] input) {
        transposeMatrix(input);
        reverseMatrix(input);
        System.out.println(Arrays.deepToString(input));
    }

    private static void transposeMatrix(int[][] input) {
        int height = input.length;
        int temp = 0;
        for (int i = 0; i < height; i++) {
            for (int j = i; j < height; j++) {
                temp = input[i][j];
                input[i][j] = input[j][i];
                input[j][i] = temp;
            }
        }
    }

    private static void reverseMatrix(int[][] input) {
        int height = input.length;
        int temp = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height / 2; j++) {
                temp = input[i][j];
                input[i][j] = input[i][height - 1 - j];
                input[i][height - 1 - j] = temp;
            }
        }
    }
}
