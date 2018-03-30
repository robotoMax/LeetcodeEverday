/**
 * 
 * Date: 03/28/2018
 * Created By: Shuai Liu
 * 
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised 
 * by the British mathematician John Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its 
 * eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * 
 * Follow up: 
 * 1. Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells 
 * first and then use their updated values to update other cells.
 * 2. In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems 
 * when the active area encroaches the border of the array. How would you address these problems?
 */
public class GameOfLife {
    int[][] dirc = {{-1, 0}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}};
    public void gameOfLife(int[][] board) {
        if (board == null || borad.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = curLive(i, j, board);
                if (board[i][j] == 0) {
                    if (live == 3) board[i][j] = 2;
                }
                else if (board[i][j] == 1) {
                    if (live < 2 || live > 3) board[i][j] = -1;
                    if (live == 2 || live == 3) continue;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) board[i][j] = 1;
                else if (board[i][j] == -1) board[i][j] = 0;
            }
        }
        return;
    }
    public int curLive(int x, int y, int[][] board) {
        int res = 0;
        for (int[] d : dirc) {
            int i = x + d[0];
            int j = y + d[1];
            if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && (board[i][j] == 1 || board[i][j] == -1)) res++;
        }
        return res;
    }
}