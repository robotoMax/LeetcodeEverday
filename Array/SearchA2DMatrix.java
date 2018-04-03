/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
/**
 * this question is same as Search a 2D Matrix II. 
 */
public class SearchA2DMatrix {
    // regular way
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            int j = matrix[0].length - 1;
            if (target == matrix[i][j]) return true;
            if (target < matrix[i][j]) {
                while (j >= 0) {
                    if (target == matrix[i][j]) return true;
                    j--;
                }
            }
        }
        return false;
    }
    // binary search
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) row++;
            else if (matrix[row][col] > target) col--;
        }
        
        return false;
    }
}