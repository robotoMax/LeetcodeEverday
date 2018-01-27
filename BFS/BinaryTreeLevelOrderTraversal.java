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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                res.get(level).add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            level++;
        }
        return res;
    }
}