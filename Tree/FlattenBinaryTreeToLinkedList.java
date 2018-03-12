/**
 * 
 * Date: 03/10/2018
 * Created By: Shuai Liu
 * 
 * Given a binary tree, flatten it to a linked list in-place.
For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            TreeNode temp = root.right;
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = temp;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }
}