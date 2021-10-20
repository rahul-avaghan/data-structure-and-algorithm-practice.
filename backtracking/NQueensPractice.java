import java.util.ArrayList;
import java.util.List;

public class NQueensPractice {
    public static void main(String[] a) {
        int n = 4;
        int board[][] = new int[n][n];
        List<List<String>> solvedBoard = new ArrayList<>();
        findWays(board, solvedBoard, new ArrayList<String>(), 0);
        System.out.println(solvedBoard);
    }

    public static void findWays(int[][] inputBoard, List<List<String>> solvedBoard, List<String> temp,
            int startPosition) {

        if (startPosition == inputBoard.length) {
            solvedBoard.add(new ArrayList<>(temp));
            return;
        }

        for (int column = 0; column < inputBoard.length; column++) {
            if (isQueenSafe(inputBoard, startPosition, column)) {
                inputBoard[startPosition][column] = 1;
                String str = convertToString(inputBoard, column);
                temp.add(str);
                findWays(inputBoard, solvedBoard, temp, startPosition + 1);
                temp.remove(str);
                inputBoard[startPosition][column] = 0;
            }
        }

    }

    private static String convertToString(int[][] inputBoard, int column) {
        String str = "";

        for (int i = 0; i < inputBoard.length; i++) {
            if (column == i) {
                str += 'Q';
            } else {
                str += ".";
            }
        }
        return str;

    }

    private static boolean isQueenSafe(int[][] board, int currentRow, int currentColumn) {

        int previousRow = currentRow - 1;
        int previousColumn = currentColumn - 1;
        int nextColumn = currentColumn + 1;
        for (int row = previousRow, column = currentColumn; row >= 0; row--) {
            if (isOccupied(board, row, column)) {
                return false;
            }
        }

        for (int row = previousRow, column = previousColumn; row >= 0 && column >= 0; row--, column--) {
            if (isOccupied(board, row, column)) {
                return false;
            }
        }

        /**
         * x x x check
         */

        for (int row = previousRow, column = nextColumn; row >= 0 && column < board.length; row--, column++) {
            if (isOccupied(board, row, column)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOccupied(int[][] board, int row, int column) {
        return board[row][column] == 1;

    }
}