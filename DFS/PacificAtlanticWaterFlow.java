/**
 * 
 * Date: 03/31/2018
 * Created By: Shuai Liu
 * 
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" 
 * touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 * Given the following 5x5 matrix:
 *   Pacific ~   ~   ~   ~   ~ 
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 * Return:
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
import java.util.*;
public class PacificAtlanticWaterFlow {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            helper(matrix, pacific, i, 0, Integer.MIN_VALUE);
            helper(matrix, atlantic, i, matrix[0].length - 1, Integer.MIN_VALUE);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            helper(matrix, pacific, 0, i, Integer.MIN_VALUE);
            helper(matrix, atlantic, matrix.length - 1, i, Integer.MIN_VALUE);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) res.add(new int[] {i, j});
            }
        }
        return res;
    }
    public void helper(int[][] matrix, boolean[][] visited, int i, int j, int height) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] < height || visited[i][j]) return;
        visited[i][j] = true;
        for (int[] d : dir) {
            helper(matrix, visited, i + d[0], j + d[1], matrix[i][j]);
        }
    }
}