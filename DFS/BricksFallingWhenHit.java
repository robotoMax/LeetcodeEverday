/**
 * 
 * Date: 03/27/2018
 * Created By: Shuai Liu
 * 
 * We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly 
 * connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.
 * 
 * We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) 
 * on that location will disappear, and then some other bricks may drop because of that erasure.
 * 
 * Return an array representing the number of bricks that will drop after each erasure in sequence.
 * 
 * Example 1:
 * Input: 
 * grid = [[1,0,0,0],[1,1,1,0]]
 * hits = [[1,0]]
 * Output: [2]
 * Explanation: 
 * If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
 * Example 2:
 * Input: 
 * grid = [[1,0,0,0],[1,1,0,0]]
 * hits = [[1,1],[1,0]]
 * Output: [0,0]
 * Explanation: 
 * When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause 
 * no bricks dropping.  Note that the erased brick (1, 0) will not be counted as a dropped brick.
 * 
 */
public class BricksFallingWhenHit {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        for (int[] h : hits) {
            if (grid[h[0]][h[1]] == 0) grid[h[0]][h[1]] = -1;
            else grid[h[0]][h[1]] = 0;
        }
        for (int i = 0; i < grid[0].length; i++) {
            helper(0, i, grid);
        }
        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == -1) continue;
            grid[x][y] = 1;
            if (!connect2top(x, y, grid)) continue;
            res[i] = helper(x, y, grid);
        }
        return res;
    }
    public int helper(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) return 0;
        grid[x][y] = 2;
        int res = 1;
        for (int[] d : dir) {
            res += helper(x + d[0], y + d[1], grid);
        }
        return res;
    }
    public boolean connect2top(int x, int y, int[][] grid) {
        if ((x - 1 >= 0 && grid[x - 1][y] == 2)
        || (y - 1 >= 0 && grid[x][y - 1] == 2)
        || (x + 1 <= grid.length - 1 && grid[x + 1][y] == 2)
        || (y + 1 <= grid[0].length - 1 && grid[x][y + 1] == 2)
        || x == 0) return true;
        return false;
    }
}