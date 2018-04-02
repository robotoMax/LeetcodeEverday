/**
 * 
 * Date: 03/30/2018
 * Created By: Shuai Liu
 * 
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only 
 * move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * 
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 * 
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 * 
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
import java.util.*;
public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int[][] dist = new int[grid.length][grid[0].length];
        int[][] reach = new int[grid.length][grid[0].length];
        int numBuildings = 0;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numBuildings++;
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    int level = 1;
                    queue.add(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int p = 0; p < size; p++) {
                            int[] cur = queue.poll();
                            for (int[] d : dir) {
                                int x = cur[0] + d[0];
                                int y = cur[1] + d[1];
                                if (x >= 0 && x < grid.length 
                                    && y >= 0 && y < grid[0].length
                                    && grid[x][y] == 0 && !visited[x][y]) {
                                    dist[x][y] += level;
                                    reach[x][y]++;
                                    visited[x][y] = true;
                                    queue.add(new int[] {x, y});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                if (reach[i][j] == numBuildings && grid[i][j] == 0) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}