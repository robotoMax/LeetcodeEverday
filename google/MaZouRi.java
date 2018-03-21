/**
 * 手机键盘的马走日，给定起点和步长（能走几步），问多少种路线可能。
 */
public class MaZouRi {
    int[][] dir = {{-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}};
    int res = 0;
    private final int row;
    private final int col;
    public MaZouRi(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int solution(int k, int p, int q) {
        boolean[][] visited = new boolean[row][col];
        helper(k, visited, p, q);
        return res;
    }
    public void helper(int k, boolean[][] visited, int x, int y) {
        if (k == 0) {
            res++;
            return;
        }
        visited[x][y] = true;
        for (int[] d : dir) {
            int i = x + d[0];
            int j = y + d[1];
            if (i >= 0 && i < row && j >= 0 && j < col && !visited[i][j]) {
                helper(k - 1, visited, i, j);
            }
        }
        visited[x][y] = false;
    }
    public static void main(String[] args) {
        MaZouRi ma = new MaZouRi(4, 4);
        int k = 2;
        int p = 0;
        int q = 1;
        System.out.println(ma.solution(k, p, q));
    }
}