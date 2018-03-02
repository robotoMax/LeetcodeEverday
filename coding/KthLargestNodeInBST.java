public class KthLargestNodeInBST {
    int res = 0;
    int count = 0;
    public int solution(TreeNode root, int k) {
        if (root == null) return 0;
        helper(root, k);
        return res;
    }
    public void helper(TreeNode root, int k) {
        if (root == null) return;
        helper(root.right, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        helper(root.left, k);
        return;
    }
    public static void main(String[] args) {
        KthLargestNodeInBST k = new KthLargestNodeInBST();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        //root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        
        System.out.println(k.solution(root, 2));
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