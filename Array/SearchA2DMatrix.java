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
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = m * n - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (matrix[mid / n][mid % n] == target) return true;
            else if (matrix[mid / n][mid % n] < target) {
                i = mid + 1;
            }
            else if (matrix[mid / n][mid % n] > target) j = mid - 1;
        }
        return false;
    }
}