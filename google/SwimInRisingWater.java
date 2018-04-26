/**
 *
 * Date: 04/19/2018
 * Created By: Shuai Liu
 *  
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
 * Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally 
 * adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. 
 * Of course, you must stay within the boundaries of the grid during your swim.
 * 
 * You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?
 * Example 1:
 * Input: [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 * Example 2:
 *
 * Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation:
 *  0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 * The final route is marked in bold.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 * Note:
 * 1. 2 <= N <= 50.
 * 2. grid[i][j] is a permutation of [0, ..., N*N - 1].
 */
import java.util.*;
public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        heap.add(new int[] {0, 0, grid[0][0]});
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int i = info[0];
            int j = info[1];
            int h = info[2];
            for (int[] d : dir) {
                int r = i + d[0];
                int c = j + d[1];
                if (r >= 0 && r < n && c >= 0 && c < n && !visited[r][c]) {
                    visited[r][c] = true;
                    int newHeight = Math.max(h, grid[r][c]);
                    if (r == n - 1 && c == n - 1) return newHeight;
                    heap.add(new int[] {r, c, newHeight});
                }
            }
        }
        return 0;
    }
}