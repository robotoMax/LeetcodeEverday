/**
 * 
 * Date: 04/01/2018
 * Created By: Shuai Liu
 * 
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * 
 * Note:
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
import java.util.*;
public class ClosestBinarySearchTreeValueII {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Integer> small = new Stack<>();
        Stack<Integer> big = new Stack<>();
        helper(root, target, small, true);
        helper(root, target, big, false);
        while (res.size() < k) {
            if (small.isEmpty()) res.add(big.pop());
            else if (big.isEmpty()) res.add(small.pop());
            else {
                res.add(Math.abs(small.peek() - target) < Math.abs(big.peek() - target) ? small.pop() : big.pop());
            }
        }
        return res;
    }
    public void helper(TreeNode root, double target, Stack<Integer> stack, boolean small) {
        if (root == null) return;
        helper(small ? root.left : root.right, target, stack, small);
        if (small) {
            if (root.val > target) return;
        }
        else {
            if (root.val <= target) return;
        }
        stack.push(root.val);
        helper(small ? root.right : root.left, target, stack, small);
    }
}