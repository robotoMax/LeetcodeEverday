/*
* Author: Shuai Liu
* Date: 01/27/2018
* 501
* Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
* Assume a BST is defined as follows:
* The left subtree of a node contains only nodes with keys less than or equal to the node's key.
* The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
* Both the left and right subtrees must also be binary search trees.
* For example:
* Given BST [1,null,2,2],
*    1
*     \
*      2
*     /
*    2
* return [2].
* Note: If a tree has more than one mode, you can return them in any order.
* Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
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
public class FindModeInBinarySearchTree {
    Integer prev = null;
    int max = 0;
    int mode = 1;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> temp = new ArrayList<>();
        helper(root, temp);
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        // return temp.stream().mapToInt(i -> i).toArray();
        return res;
    }
    public void helper(TreeNode root, List<Integer> temp) {
        if (root == null) return;
        helper(root.left, temp);
        if (prev != null) {
            if (prev == root.val) {
                mode++;
            }
            else {
                mode = 1;
            }
        }
        if (mode > max) {
            max = mode;
            temp.clear();
            temp.add(root.val);
        }
        else if (mode == max) {
            temp.add(root.val);
        }
        prev = root.val;
        helper(root.right, temp);
    }
}