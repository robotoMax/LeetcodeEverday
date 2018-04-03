/**
 * 
 * Date: 04/02/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 */
import java.util.*;
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, res, "");
        return res;
    }
    public void helper(TreeNode root, List<String> res, String temp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            temp += root.val;
            res.add(temp);
        }
        helper(root.left, res, temp + root.val + "->");
        helper(root.right, res, temp + root.val + "->");
    }
}