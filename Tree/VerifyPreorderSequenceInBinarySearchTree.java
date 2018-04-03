/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 * Follow up:
 * Could you do it using only constant space complexity?
 */
import java.util.*;
public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int i : preorder) {
            if (i < low) return false;
            while (!stack.isEmpty() && i > stack.peek()) {
                low = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }
    // O(1) Space complexity
    public boolean verifyPreorder1(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        int low = Integer.MIN_VALUE;
        int i = -1;
        for (int node : preorder) {
            if (node < low) return false;
            while (i >= 0 && node > preorder[i]) {
                low = preorder[i--];
            }
            preorder[++i] = node;
        }
        return true;
    }    
}