import java.util.ArrayList;
import java.util.List;

class NQueens {
    public static void main(String[] args) {
        int n = 4;
        int board[][] = new int[n][n];
        List<List<String>> solvedBoard = new ArrayList<>();
        findWays(board, new ArrayList<String>(), solvedBoard, 0);
        System.out.println(solvedBoard);
    }

    public static void findWays(int[][] inputBoard, List<String> temp, List<List<String>> solvedBoard, int startPosition) {
        boolean traverseComplete = startPosition == inputBoard.length;

        // If you reach the last row then the temp queen positions qualifies to be a solution
        if (traverseComplete) {
            solvedBoard.add(new ArrayList<>(temp));
            return;
        }
        int horizontalEnd = inputBoard.length;
        // traverse horizontally for each row.
        for (int column = 0; column < horizontalEnd; column++) {

            if (isQueenSafe(inputBoard, startPosition, column)) {
                inputBoard[startPosition][column] = 1;
                String str = convertToString(inputBoard, column);
                temp.add(str);
                int nextRow = startPosition + 1;
                findWays(inputBoard, temp, solvedBoard, nextRow);
                temp.remove(str);
                inputBoard[startPosition][column] = 0;
            }
        }
    }

    private static String convertToString(int[][] board, int presentColumn) {
        String str = "";
        int horizontalEnd = board.length;
        for (int column = 0; column < horizontalEnd; column++) {
            if (column == presentColumn) {
                str += 'Q';
            } else {
                str += '.';
            }
        }
        return str;
    }

    public static boolean isQueenSafe(int[][] board, int currentRow, int currentColumn) {
        int previousRow = currentRow - 1;
        int previousColumn = currentColumn - 1;
        int nextColumn = currentColumn + 1;
        // scan horizontally till
        // start from previous row till starting row
        for (int row = previousRow, column = currentColumn; row >= 0; row--) {
            if (booked(row, column, board)) {
                return false;
            }

        }
        // start from previous diagonal cell to starting cell
        for (int row = previousRow, column = previousColumn; row >= 0 && column >= 0; row--, column--) {
            if (booked(row, column, board)) {
                return false;
            }
        }
        // start from previous diagonal cell to starting cell

        for (int row = previousRow, column = nextColumn; row >= 0 && column < board.length; row--, column++) {
            if (booked(row, column, board)) {
                return false;
            }
        }
        return true;
    }

    private static boolean booked(int row, int column, int[][] board) {
        return board[row][column] == 1;
    }
}