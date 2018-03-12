/**
 * 
 * Date: 03/11/2018
 * Created By: Shuai Liu
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both 
 * indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
/**
 * int[] queens represents at this ith row, the queen is at jth col
 * if queen is at row 3 col 2 queen[3] = 2;
 */
import java.util.*;
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, new int[n], 0);
        return res;
    }
    public void helper(List<List<String>> res, int[] queens, int row) {
        if (row == queens.length) {
            addSolution(res, queens);
            return;
        }
        for (int col = 0; col < queens.length; col++) {
            queens[row] = col;
            if (isValid(queens, row)) {
                helper(res, queens, row + 1);
            }
        }
        return;
    }
    public boolean isValid(int[] queens, int row) {
        for (int i = 0; i < row; i++) {
            if (queens[row] == queens[i]) return false; // to see whether two queens are in the same col
            else if (Math.abs(queens[row] - queens[i]) == Math.abs(row - i)) return false; // to see whether two queens are diagonal. if they are, the difference between the rows and the difference between cols are equal.
        }
        return true;
    }
    public void addSolution(List<List<String>> res, int[] queens) {
        List<String> temp = new ArrayList<>();
        for (int row = 0; row < queens.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < queens.length; col++) {
                if (queens[row] == col) {
                    sb.append("Q");
                }
                else sb.append(".");
            }
            temp.add(sb.toString());
        }
        res.add(temp);
    }
}