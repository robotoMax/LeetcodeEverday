public class DiagonalMatrix {
    
    // case 1
    // {{1,2,3},
    // {4,5,6},
    // {7,8,9}}
    // return {1,2,4,7,5,3,6,8,9}

    public int[] case1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int row = 0;
        int col = 0;
        int d = 1;
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[row][col];
            row -= d;
            col += d;
            if (row >= m) {
                row = m - 1;
                col += 2;
                d = -d;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                d = -d;
            }
            if (row < 0) {
                row = 0;
                d = -d;
            }
            if (col < 0) {
                col = 0;
                d = -d;
            }
        }
        return res;
    }


    // case 2:
    // {{1,2,3},
    // {4,5,6},
    // {7,8,9}}
    // return {1,4,2,3,5,7,8,6,9}

    public int[] case2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int row = 0;
        int col = 0;
        int d = -1;
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[row][col];
            row -= d;
            col += d;
            if (row >= m) {
                row = m - 1;
                col += 2;
                d = -d;
            }
            if (col >= n) {
                col = n - 1;
                row += 2;
                d = -d;
            }
            if (row < 0) {
                row = 0;
                d = -d;
            }
            if (col < 0) {
                col = 0;
                d = -d;
            }
        }
        return res;
    }

    // case3:
    public int[] case3(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m];
        int row = matrix.length - 1;
        int col = 0;
        for (int i = 0; i < m; i++) {
            res[i] = matrix[row--][col++];
        }
        return res;
    }



    public static void main(String[] args) {
        DiagonalMatrix d = new DiagonalMatrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] res = d.case3(matrix);
        // for (int i = 0; i < matrix.length; i++) System.out.println(res[i]);
    }



}