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
        int[][] dp = new int[k + 1][col * row + 1];
        helper(k, visited, p, q, dp);
        return dp[k][p * col + q];
    }
    public int helper(int k, boolean[][] visited, int x, int y, int[][] dp) {
        if (k == 0) return 1;
        if (dp[k][x * col + y] > 0) return dp[k][x * col + y];
        int temp = 0;
        visited[x][y] = true;
        for (int[] d : dir) {
            int i = x + d[0];
            int j = y + d[1];
            if (i >= 0 && i < row && j >= 0 && j < col) {
                temp += helper(k - 1, visited, i, j, dp);
            }
        }
        visited[x][y] = false;
        dp[k][x * col + y] = temp;
        return temp;
    }
    public static void main(String[] args) {
        MaZouRi ma = new MaZouRi(4,3);
        int k =13;
        int p = 0;
        int q = 0;
        System.out.println(ma.solution(k, p, q));
    }
// 1 2 3
// 4 5 6
// 7 8 9
// * 0 #


    // public int solution(int k, int p, int q) {
    //     boolean[][] visited = new boolean[row][col];
    //     helper(k, visited, p, q);
    //     return res;
    // }
    // public void helper(int k, boolean[][] visited, int x, int y) {
    //     if (k == 0) {
    //         res++;
    //         return;
    //     }
    //     visited[x][y] = true;
    //     for (int[] d : dir) {
    //         int i = x + d[0];
    //         int j = y + d[1];
    //         if (i >= 0 && i < row && j >= 0 && j < col && !visited[i][j]) {
    //             helper(k - 1, visited, i, j);
    //         }
    //     }
    //     visited[x][y] = false;
    // }
}