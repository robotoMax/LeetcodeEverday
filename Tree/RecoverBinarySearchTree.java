/**
 * 
 * Date: 03/16/2018
 * Created By: Shuai Liu
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
/**
 * inorder traversal with the pre node as instance variable.
 * simialar to validate binary search tree
 */
public class RecoverBinarySearchTree {
    // recursion inorder traversal
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode[] temp = new TreeNode[2];
        helper(root, temp);
        int a = temp[0].val;
        temp[0].val = temp[1].val;
        temp[1].val = a;
        return;
    }
    public void helper(TreeNode root, TreeNode[] temp) {
        if (root == null) return;
        helper(root.left, temp);
        if (pre != null) {
            if (temp[0] == null && pre.val >= root.val) temp[0] = pre;
            if (temp[0] != null && pre.val >= root.val) temp[1] = root;
        }
        pre = root;
        helper(root.right, temp);
        return;
    }

    // this can be done by using morris traversal: 
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode temp = null;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;
        while(root != null){
            temp = root.left;
            if(temp != null){
                while (temp.right != null && temp.right != root){
                    temp = temp.right;
                }
                if(temp.right != null){
                    if (pre != null && pre.val > root.val) { 
                        if(first == null){
                            first = pre;
                            second = root;
                        }
                        else second = root;
                    }
                    pre = root;
                    temp.right = null;
                    root = root.right;
                }
                else {
                    temp.right = root;
                    root = root.left;
                }
            }
            else {
                if (pre != null && pre.val > root.val) {
                    if(first == null){
                        first = pre;
                        second =root;
                    }
                    else second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
        return;
    }
	public void morrisTraversal(TreeNode root){
		TreeNode temp = null;
		while(root!=null){
			if(root.left!=null){
				// connect threading for root
				temp = root.left;
				while(temp.right!=null && temp.right != root)
					temp = temp.right;
				// the threading already exists
				if(temp.right!=null){
					temp.right = null;
					System.out.println(root.val);
					root = root.right;
				}else{
					// construct the threading
					temp.right = root;
					root = root.left;
				}
			}else{
				System.out.println(root.val);
				root = root.right;
			}
		}
	}
}