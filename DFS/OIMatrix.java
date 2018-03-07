/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * 
 * The distance between two adjacent cells is 1.
 * Example 1: 
 * Input:
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Output:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Example 2: 
 * Input:
 * 
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * Output:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 */
import java.util.*;
public class OIMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) queue.add(new int[] {i, j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] dirc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirc) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == Integer.MAX_VALUE) {
                    matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
                    queue.add(new int[] {x, y});
                }
            }
        }
        return matrix;
    }
}