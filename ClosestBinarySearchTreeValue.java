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
    int res = 0;
    double diff = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        helper(root, target);
        return res;
    }
    public void helper(TreeNode root, double target) {
        if (root == null) return;
        helper(root.left, target);
        if (Math.abs(root.val - target) < diff) {
            diff = Math.abs(root.val - target);
            res = root.val;
        }
        helper(root.right, target);
    }
}