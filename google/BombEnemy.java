import java.util.Arrays;

/**
 * 
 * Date: 03/21/2018
 * Created By: Shuai Liu
 * 
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * Example:
 * For the given grid
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        int rowCount = 0;
        int[] colCount = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    int temp = 0;
                    for (int p = j; p < grid[0].length && grid[i][p] != 'W'; p++) {
                        if (grid[i][p] == 'E') temp++;
                    }
                    rowCount = temp;
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    int temp = 0;
                    for (int p = i; p < grid.length && grid[p][j] != 'W'; p++) {
                        if (grid[p][j] == 'E') temp++;
                    }
                    colCount[j] = temp;
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, rowCount + colCount[j]);
                }
            }
        }
        return res;
    }
    // follow up:
    // the output need to be a 2D matrix. Each position indicates how many enemy you can see. If char[i][j] != '0', the result will be 0;
    public int[][] solution(char[][] grid) {
        if (grid == null || grid.length == 0) return new int[0][0];
        int[][] res = new int[grid.length][grid[0].length];
        int rowCount = 0;
        int[] colCount = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    int temp = 0;
                    for (int p = j; p < grid[0].length && grid[i][p] != 'W'; p++) {
                        if (grid[i][p] == 'E') temp++;
                    }
                    rowCount = temp;
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    int temp = 0;
                    for (int p = i; p < grid.length && grid[p][j] != 'W'; p++) {
                        if (grid[p][j] == 'E') temp++;
                    }
                    colCount[j] = temp;
                }
                if (grid[i][j] == '0') {
                    res[i][j] = rowCount + colCount[j];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        BombEnemy b = new BombEnemy();
        char[][] grid = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        int[][] res = b.solution(grid);
        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
    }
    // follow up:
    
}