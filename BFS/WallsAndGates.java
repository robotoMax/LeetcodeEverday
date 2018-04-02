/**
 * 
 * Date: 04/01/2018
 * Created By: Shuai Liu
 * 
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * 1. -1 - A wall or an obstacle.
 * 2. 0 - A gate.
 * 3. INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that 
 * the distance to a gate is less than 2147483647.
 * 
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * 
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
import java.util.*;
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[] {i, j});
            }
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x >=0 && x < rooms.length && y >= 0 && y < rooms[0].length && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
                    queue.add(new int[] {x, y});
                }
            }
        }
    }
}