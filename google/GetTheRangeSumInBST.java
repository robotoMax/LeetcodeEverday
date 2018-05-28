/**
 * 给一个BST，和一个min以及max，求在min和max之间的所有元素和
 */
/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
public class GetTheRangeSumInBST {
    int res = 0;
    public int solution(TreeNode root, int min, int max) {
        if (root == null) return 0;
        helper(root, min, max);
        return res;
    }
    public void helper(TreeNode root, int min, int max) {
        if (root == null) return;
        helper(root.left, min, max);
        if (root.val > min && root.val < max) {
            res += root.val;
        }
        helper(root.right, min, max);
    }
    /**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        GetTheRangeSumInBST g = new GetTheRangeSumInBST();
        int min = 3;
        int max = 6;
        System.out.println(g.solution(root, min, max));
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