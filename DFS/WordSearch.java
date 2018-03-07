/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * 
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 */
public class WordSearch {
    int[][] dirc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                if (helper(board, word, i, j, visited, 0)) return true;
            }
        }
        return false;
    }
    public boolean helper(char[][] board, String word, int i, int j, boolean[][] visited, int pos) {
        if (pos == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(pos)) return false;
        visited[i][j] = true;
        for (int[] dir : dirc) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (helper(board, word, x, y, visited, pos + 1)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}   