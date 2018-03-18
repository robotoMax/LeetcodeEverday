/**
 * 
 * Date: 03/17/2018
 * Created By: Shuai Liu
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute 
 * how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
/**
 * this question is similar with Largest Rectangle In Histogram. They both use stack.
 */
import java.util.*;
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int dist = i - stack.peek() - 1;
                int high = Math.min(height[i], height[stack.peek()]);
                res += dist * (high - height[top]);
            }
            stack.push(i);
        }
        return res;
    }
}