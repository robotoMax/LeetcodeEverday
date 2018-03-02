// given a tree:
//     3
//    / \
//   4   1
//  / \   \
// 1   5   6
// return 341 + 345 + 316

public class PathSum {
    int res = 0;
    public int solution(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return res;
    }
    public void helper(TreeNode root, int cur) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            cur = cur * 10 + root.val;
            System.out.println(cur);
            res += cur;
            return;
        }
        if (root.left != null) helper(root.left, cur * 10 + root.val);
        if (root.right != null) helper(root.right, cur * 10 + root.val);
        return;
    }
    public static void main(String[] args) {
        PathSum p = new PathSum();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        // root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        System.out.println(p.solution(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
