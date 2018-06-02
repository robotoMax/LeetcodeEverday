/**
 * Date: 05/30/2018
 * Created By: Shuai Liu
 * 
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of 
 * water it is able to trap after raining.
 * 
 * Note:
 * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
 * Example:
 * Given the following 3x6 height map:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 * Return 4.
 */
import java.util.*;
public class TrappingRainWaterII {
    private class Cell {
        int x; 
        int y;
        int h;
        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        PriorityQueue<Cell> heap = new PriorityQueue<>(1, (a, b) -> a.h - b.h);
        int res = 0;
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        for (int i = 0; i < heightMap.length; i++) {
            visited[i][0] = true;
            visited[i][heightMap[0].length - 1] = true;
            heap.add(new Cell(i, 0, heightMap[i][0]));
            heap.add(new Cell(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
        }
        for (int i = 0; i < heightMap[0].length; i++) {
            if (!visited[0][i]) heap.add(new Cell(0, i, heightMap[0][i]));
            if (!visited[heightMap.length - 1][i]) heap.add(new Cell(heightMap.length - 1, i, heightMap[heightMap.length - 1][i]));
            visited[0][i] = true;
            visited[heightMap.length - 1][i] = true;
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!heap.isEmpty()) {
            Cell cur = heap.poll();
            for (int[] d : dir) {
                int left = cur.x + d[0];
                int right = cur.y + d[1];
                if (left >= 0 && left < heightMap.length && right >= 0 && right < heightMap[0].length && !visited[left][right]) {
                    visited[left][right] = true;
                    res += Math.max(0, cur.h - heightMap[left][right]);
                    heap.add(new Cell(left, right, Math.max(cur.h, heightMap[left][right])));
                }
            }
        }
        return res;
    }
}