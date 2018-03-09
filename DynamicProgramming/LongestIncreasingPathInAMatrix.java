/**
 * 
 * Date: 03/08/2018
 * Created By: Shuai Liu
 * 
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * From each cell, you can either move to four directions: left, right, up or down. 
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * 
 * Example 1:
 * 
 * nums = [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * Example 2:
 * 
 * nums = [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
/**
 * same as coin change
 */
public class LongestIncreasingPathInAMatrix {
    int[][] dirc = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 1;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = helper(matrix, i, j, cache, Integer.MIN_VALUE);
                res = Math.max(res, len);
            }
        }
        return res;
    }
    public int helper(int[][] matrix, int i, int j, int[][] cache, int pre) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre) return 0;
        if (cache[i][j] > 0) return cache[i][j];
        int res = 1;
        for (int[] dir : dirc) {
            int x = i + dir[0];
            int y = j + dir[1];
            int temp = helper(matrix, x, y, cache, matrix[i][j]);
            res = Math.max(res, temp + 1);
        }
        cache[i][j] = res;
        return cache[i][j];
    }
}