/**
 * 
 * Date: 04/15/2018
 * Created By: Shuai Liu
 * 
 * Given a circular array (the next element of the last element is the first element of the array), print the Next 
 * Greater Number for every element. The Next Greater Number of a number x is the first greater number to its 
 * traversing-order next in the array, which means you could search circularly to find its next greater number. 
 * If it doesn't exist, output -1 for this number.
 * 
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; 
 * The number 2 can't find next greater number; 
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */

import java.util.*;
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 2 * len - 1; i >= 0; i--) {
            int index = i % len;
            // we need to pop the smaller ones in the stack. And if the stack is empty, then there are no bigger number in its right.
            // Add the current number to the stack.
            while (!stack.isEmpty() && stack.peek() <= nums[index]) stack.pop();
            res[index] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[index]);
        }
        return res;
    }
}