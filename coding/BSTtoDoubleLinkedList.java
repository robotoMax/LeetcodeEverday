public class BSTtoDoubleLinkedList {
    TreeNode pre = null;
    public TreeNode solution(TreeNode root) {
        if (root == null) return null;
        TreeNode dum = root;
        helper(root);
        return dum;
    }

    public TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode left = solution(root.left);
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        //System.out.println(pre.val);
        TreeNode right = solution(root.right);
        return root;
    }

    public static void main(String[] args) {
        BSTtoDoubleLinkedList b = new BSTtoDoubleLinkedList();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        TreeNode cur = b.solution(root);
        // while (cur != null) {
        //     System.out.println("test left pointer: " + cur.val);
        //     cur = cur.left;
        // }
        while (cur != null) {
            System.out.println("test right pointer: " + cur.val);
            cur = cur.right;
        }
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
}