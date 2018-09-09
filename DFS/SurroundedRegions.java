/**
 * Date: 08/19/2018
 * Created By: Shuai Liu
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * Example:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' 
 * that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they 
 * are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') helper(board, 0, i, '1', new boolean[board.length][board[0].length]);
            if (board[board.length - 1][i] == 'O') helper(board, board.length - 1, i, '1', new boolean[board.length][board[0].length]);
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') helper(board, i, 0, '1', new boolean[board.length][board[0].length]);
            if (board[i][board[0].length - 1] == 'O') helper(board, i, board[0].length - 1, '1', new boolean[board.length][board[0].length]);
        }
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
        return;
    }
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void helper(char[][] board, int i, int j, char change, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || visited[i][j]) {
            return;
        }
        board[i][j] = change;
        visited[i][j] = true;
        for (int[] d : dir) {
            int x = d[0] + i;
            int y = d[1] + j;
            helper(board, x, y, change, visited);
        }
    }
}