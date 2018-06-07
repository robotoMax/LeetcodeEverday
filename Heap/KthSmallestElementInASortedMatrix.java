/**
 * Date: 06/02/2018
 * Created By: Shuai Liu
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth 
 * smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Example:
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * return 13.
 */
import java.util.*;
public class KthSmallestElementInASortedMatrix {

    private class Cell {
        int x;
        int y;
        int val;
        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return 0;
        PriorityQueue<Cell> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < matrix[0].length; i++) heap.add(new Cell(0, i, matrix[0][i]));
        for (int i = 0; i < k - 1; i++) {
            Cell cur = heap.poll();
            if (cur.x == matrix.length - 1) continue;
            heap.add(new Cell(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        }
        return heap.poll().val;
    }

}