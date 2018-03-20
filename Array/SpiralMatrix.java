/**
 * 
 * Date: 03/19/2018
 * Created By: Shuai Liu
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
import java.util.*;
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int rowB = 0;
        int rowE = matrix.length - 1;
        int colB = 0;
        int colE = matrix[0].length - 1;
        while (rowB <= rowE && colB <= colE) {
            for (int i = colB; i <= colE; i++) res.add(matrix[rowB][i]);
            rowB++;
            for (int i = rowB; i <= rowE; i++) res.add(matrix[i][colE]);
            colE--;
            if (rowB <= rowE) {
                for (int i = colE; i >= colB; i--) {
                    res.add(matrix[rowE][i]);
                }
            }
            rowE--;
            if (colB <= colE) {
                for (int i = rowE; i >= rowB; i--) {
                    res.add(matrix[i][colB]);
                }
            }
            colB++;
        }
        return res;
    }
}