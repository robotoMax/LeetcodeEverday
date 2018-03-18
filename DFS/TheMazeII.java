/**
 * 
 * Date: 03/17/2018
 * Created By: Shuai Liu
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, 
 * down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the 
 * next direction.
 * 
 * Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at 
 * the destination. The distance is defined by the number of empty spaces traveled by the ball from the start 
 * position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that 
 * the borders of the maze are all walls. The start and destination coordinates are represented by row and column 
 * indexes.
 * Example 1
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)

 * Output: 12
 * Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
 *              The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

 * Example 2

 * Input 1: a maze represented by a 2D array

 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0

 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)

 * Output: -1
 * Explanation: There is no way for the ball to stop at the destination.

 * Note:
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the example pictures), but you could assume t
 * he border of the maze are all walls.
 * The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

 */
import java.util.*;
public class TheMazeII {
    // DFS ---- sometime it will be AC, sometime it will be time exceed limited
    int[][] dirc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return 0;
        Integer[][] dist = new Integer[maze.length][maze[0].length];
        dist[start[0]][start[1]] = 0;
        helper(maze, start, destination, dist);
        return dist[destination[0]][destination[1]] == null ? -1 : dist[destination[0]][destination[1]];
    }
    public void helper(int[][] maze, int[] start, int[] dest, Integer[][] dist) {
        if (start.equals(dest)) return;
        for (int[] dir : dirc) {
            int i = start[0];
            int j = start[1];
            int len = dist[i][j];
            while (i + dir[0] >= 0 && i + dir[0] < maze.length && j + dir[1] >= 0 && j + dir[1] < maze[0].length && maze[i + dir[0]][j + dir[1]] == 0) {
                i += dir[0];
                j += dir[1];
                len++;
            }
            if (dist[i][j] != null && dist[i][j] <= len) continue;
            dist[i][j] = len;
            helper(maze, new int[] {i, j}, dest, dist);
        }
    }
    // BFS
    public int shortestDistance1(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return 0;
        int[][] dist = new int[maze.length][maze[0].length];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(start[0], start[1], 0));
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int[] dir : dirc) {
                int i = cur.x;
                int j = cur.y;
                int len = cur.val;
                while (i + dir[0] >= 0 && i + dir[0] < maze.length && j + dir[1] >= 0 && j + dir[1] < maze[0].length && maze[i + dir[0]][j + dir[1]] == 0) {
                    i += dir[0];
                    j += dir[1];
                    len++;
                }
                if (len >= dist[i][j]) continue;
                dist[i][j] = len;
                queue.offer(new Cell(i, j, len));
            }
        }
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
    private class Cell {
        int x;
        int y;
        int val;
        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}