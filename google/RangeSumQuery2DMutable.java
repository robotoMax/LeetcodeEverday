/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower 
 * right corner (row2, col2).
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 * Note:
 * The matrix is only modifiable by the update function.
 * You may assume the number of calls to update and sumRegion function is distributed evenly.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DMutable {

    int[][] BinaryIndexedTree2D;
    int[][] matrix;

    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        this.matrix = matrix;
        this.BinaryIndexedTree2D = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                insert(i, j, matrix[i][j]);
            }
        }
    }
    
    public void insert(int i, int j, int val) {
        for (int x = i + 1; x < BinaryIndexedTree2D.length; x += (x & -x)) {
            for (int y = j + 1; y < BinaryIndexedTree2D[0].length; y += (y & -y)) {
                BinaryIndexedTree2D[x][y] += val;
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col]; 
        insert(row, col, diff);
        matrix[row][col] = val;
    }

    public int getSum(int i, int j) {
        int res = 0;
        for (int x = i + 1; x > 0; x -= (x & -x)) {
            for(int y = j + 1; y > 0; y -= (y & -y)) {
                res += BinaryIndexedTree2D[x][y];
            }
        }
        return res;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) + getSum(row1 - 1, col1 - 1) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1);
    }
}