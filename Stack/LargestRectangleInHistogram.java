/**
 * 
 * Date: 03/17/2018
 * Created By: Shuai Liu
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is 10 unit.
 * 
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 */
/**
 * 85. Maximal Rectangle use this way to get the max rectangle. Basically, it iterates each row to find the maximum histogram rectangle.
 */
import java.util.*;
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) stack.push(i);
            else {
                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int top = stack.pop();
                    int area = heights[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                    max = Math.max(area, max);
                }
                stack.push(i);
            }
        }
        return max;
    }
}