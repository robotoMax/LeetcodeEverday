/*
* Author: Shuai Liu
* Date: 01/27/2018
* 102
* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
*
* For example:
* Given binary tree [3,9,20,null,null,15,7],
*    3
*   / \
*  9  20
*    /  \
*   15   7
* return its level order traversal as:
* [
*   [3],
*   [9,20],
*   [15,7]
* ]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, 0);
        return res;
    }
    public static void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(new ArrayList<>());
            res.get(level).add(root.val);
        }
        else {
            res.get(level).add(root.val);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
        return;
    }
}