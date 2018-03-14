/**
 * 
 * Date: 03/13/2018
 * Created By: Shuai Liu
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded 
 * by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges 
 * of the grid are all surrounded by water.
 * 
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class NumberOfIslands {
    static int[][] dirc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') continue;
                helper(grid, i, j);
                res++;
            }
        }
        return res;
    }
    public void helper(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int[] dir : dirc) {
            int x = i + dir[0];
            int y = j + dir[1];
            helper(grid, x, y);
        }
    }
    // ***************************************************************************************************
    // follow up: what is the largest area of the island?
    static int area = 1;
    public static int areaIsland(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') continue;
                helper(grid, i, j, new int[] {1});
            }
        }
        return area;
    }
    public static void helper(char[][] grid, int i, int j, int[] cur) {
        grid[i][j] = '0';
        area = Math.max(area, cur[0]);
        for (int[] dir : dirc) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') continue;
            cur[0] += 1;
            helper(grid, x, y, cur);
        }
    }
    public static void main(String[] args) {
        char[][] grid = {{'0', '1', '0', '1', '0'}, 
                         {'1', '1', '0', '1', '0'},
                         {'1', '0', '1', '1', '0'},
                         {'0', '0', '0', '1', '1'}};
        System.out.println(areaIsland(grid));
    }
}