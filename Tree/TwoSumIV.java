/**
 * 
 * Date: 03/06/2018
 * Created By: Shuai Liu
 * 
 * Given a Binary Search Tree and a target number, 
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
import java.util.*;
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }
    public boolean helper(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return helper(root.left, k, set) || helper(root.right, k, set);
    }
}