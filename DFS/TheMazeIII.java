/**
 * 
 */
import java.util.*;
public class TheMazeIII {
    private class Cell implements Comparable<Cell> {
        int x;
        int y;
        int val;
        String path;
        public Cell (int x, int y) {
            this(x, y, Integer.MAX_VALUE, "");
        }
        public Cell(int x, int y, int val, String path) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.path = path;
        }
        @Override
        public int compareTo(Cell c) {
            if (c.val == val) return path.compareTo(c.path);
            return Integer.compare(val, c.val);
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length == 0) return "";
        int m = maze.length;
        int n = maze[0].length;
        Cell[][] cells = new Cell[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) cells[i][j] = new Cell(i, j);
        }
        int[][] dirc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        String[] path = {"d", "r", "u", "l"};
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(ball[0], ball[1], 0, ""));
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            if (cells[cur.x][cur.y].compareTo(cur) < 0) continue;
            cells[cur.x][cur.y] = cur;
            for (int i = 0; i < 4; i++) {
                int l = cur.x;
                int r = cur.y;
                int len = cur.val;
                int p = dirc[i][0];
                int q = dirc[i][1];
                while (l >= 0 && l < m && r >= 0 && r < n && maze[l][r] == 0 && (l != hole[0] || r != hole[1])) {
                    l += p;
                    r += q;
                    len++;
                }
                if (l != hole[0] || r != hole[1]) {
                    l -= p;
                    r -= q;
                    len--;
                }
                queue.add(new Cell(l, r, len, cur.path + path[i]));
            }
        }
        return cells[hole[0]][hole[1]].val == Integer.MAX_VALUE ? "impossible" : cells[hole[0]][hole[1]].path;
    }
}