public class MaxConnectNode {
    int res = 0;
    public int solution(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int cur = 1;
        if (root.left != null && root.val == root.left.val) {
            cur += left;
        }
        if (root.right != null && root.val == root.right.val) {
            cur += right;
        }
        res = Math.max(res, cur);
        return cur;
    }

    public static void main(String[] args) {
        MaxConnectNode m = new MaxConnectNode();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        System.out.println(m.solution(root));
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