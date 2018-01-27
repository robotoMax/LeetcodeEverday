/*
* Author: Shuai Liu
* Date: 01/27/2018
* 105
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
public class ConstructBinaryTreeFromPreorderandInorderTraversal{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int index = findRoot(in, root.val, inStart, inEnd);
        int len = index - inStart;
        root.left = helper(pre, preStart + 1, preStart + len, in, inStart, index - 1);
        root.right = helper(pre, preStart + len + 1, preEnd, in, index + 1, inEnd);
        return root;
    }
    public int findRoot(int[] in, int val, int i, int j) {
        int res = 0;
        for (int p = i; p <= j; p++) {
            if (in[p] == val) {
                res = p;
                break;
            }   
        }
        return res;
    }
}