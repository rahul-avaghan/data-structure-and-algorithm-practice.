import java.util.Arrays;

public class GridTraversal {

    public static void main(String[] args) {
        traverse();
    }

    private static void traverse() {

        int[][] grid = new int[3][3];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], -1);
        }
        countPaths(0, 0, 3, 3, grid);

        System.out.println("count paths :" + grid[0][0]);
        System.out.println(Arrays.deepToString(grid));

    }

    private static int countPaths(int row, int col, int height, int width, int[][] grid) {

        if (row == width - 1 && col == height - 1) {
            return 1;
        }

        if (row >= width || col >= height) {
            return 0;
        }

        if (grid[row][col] != -1) {
            return grid[row][col];
        }

        return  grid[row][col]= countPaths(row, col + 1, height, width, grid)
                + countPaths(row + 1, col, height, width, grid);
    }
}
