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
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 1;
        int[][] dist = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = helper(matrix, i, j, dist);
                res = Math.max(res, temp);
            }
        }
        return res;
    }
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int helper(int[][] matrix, int x, int y, int[][] visited) {
        if (visited[x][y] > 0) return visited[x][y];
        int dist = 1;
        for (int[] d : dir) {
            int i = x + d[0];
            int j = y + d[1];
            int temp = 0;
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] > matrix[x][y]) {
                temp += helper(matrix, i, j, visited) + 1;
            }
            dist = Math.max(temp, dist);
        }
        visited[x][y] = dist;
        return dist;
    }
}