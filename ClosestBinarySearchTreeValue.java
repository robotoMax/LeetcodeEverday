/**
 * 
 * Date: 04/01/2018
 * Created By: Shuai Liu
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Note:
 * 1. Given target value is a floating point.
 * 2. You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode next = root.val < target ? root.right : root.left;
        if (next == null) return a;
        int b = closestValue(next, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}