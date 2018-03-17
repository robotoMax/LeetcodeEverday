/**
 * 
 * Date: 03/16/2018
 * Created By: Shuai Liu
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, 
 * but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the 
 * maze are all walls. The start and destination coordinates are represented by row and column indexes.
 * Example 1
 * Input 1: a maze represented by a 2D array
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 * Example 2
 * Input 1: a maze represented by a 2D array
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination.
 * Note:
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 * The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 */
public class TheMaze {
    int[][] dirc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return helper(maze, start[0], start[1], destination[0], destination[1], visited);
    }
    public boolean helper(int[][] maze, int x, int y, int i, int j, boolean[][] visited) {
        if (x == i && y == j) return true;
        if (visited[x][y]) return false;
        visited[x][y] = true;
        for (int[] dir : dirc) {
            int left = x;
            int right = y;
            while (left + dir[0] >= 0 
                && left + dir[0] < maze.length 
                && right + dir[1] >= 0 
                && right + dir[1] < maze[0].length 
                && maze[left + dir[0]][right + dir[1]] != 1) {
                left += dir[0];
                right += dir[1];
            }
            if (helper(maze, left, right, i, j, visited)) return true;
        }
        return false;
    }
}