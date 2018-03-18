/**
 * 
 * Date: 03/17/2018
 * Created By: Shuai Liu
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and 
 * return its area.
 * 
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 6.
 */
import java.util.*;
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[] histogram = new int[matrix[0].length];
        int max = 0;
        for (char[] row : matrix) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= row.length; i++) {
                if (i < row.length) {
                    if (row[i] == '1') histogram[i] += 1;
                    else histogram[i] = 0;
                }
                int h = i == row.length ? 0 : histogram[i];
                if (stack.isEmpty() || h >= histogram[stack.peek()]) stack.push(i);
                else {
                    while (!stack.isEmpty() && h < histogram[stack.peek()]) {
                        int top = stack.pop();
                        int area = histogram[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                        max = Math.max(area, max);
                    }
                    stack.push(i);
                }
            }
        }
        return max;
    }
}