import java.util.Arrays;

public class SetMatrixToZero {

    public static void main(String[] args) {
        // int[][] input = { { 1, 1, 1, 0 },
        //         { 1, 1, 0, 1 }
        // };

        int[][] input = { { 2, 1, 1, 1 },
        { 3, 1, 0, 1 },
        { 4, 1, 1, 1 },

};
        System.out.println(input.toString());
        printMatrix(input);
        setMatrixToZero(input);
        printMatrix(input);

    }

    public static void setMatrixToZero(int[][] matrix) {
        int col0 = 1, rows = matrix.length;
        int lastRow = rows - 1;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0)
            col0 = 0;
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = matrix[0][col] = 0;
                }
            }
        }

        for (int row = lastRow; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 1; col--) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
            if (col0 == 0)
                matrix[row][0] = 0;
        }

    }

    public static void printMatrix(int[][] input) {
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[row].length; col++) {
                System.out.print(input[row][col] + " ");

            }
            System.out.println();
        }
    }
}