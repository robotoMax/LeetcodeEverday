/*
* Author: Shuai Liu
* Date: 01/27/2018
* 106
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode helper(int[] in, int inStart, int inEnd, int[] post, int pStart, int pEnd) {
        if (inStart > inEnd || pStart > pEnd) return null;
        TreeNode root = new TreeNode(post[pEnd]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                index = i;
                break;
            }
        }
        int len = inEnd - index;
        root.left = helper(in, inStart, index - 1, post, pStart, pEnd - len - 1);
        root.right = helper(in, index + 1, inEnd, post, pEnd - len, pEnd - 1);
        return root;
    }
}