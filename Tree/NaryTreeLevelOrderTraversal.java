/**
 * Date: 07/17/2018
 * Created By: Shuai Liu
 * 
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        res.add(new ArrayList<>());
        res.get(0).add(root.val);
        helper(root, res, 1);
        return res;
    }
    public void helper(Node root, List<List<Integer>> res, int level) {
        if (root == null || root.children.size() == 0) return;
        if (res.size() == level) res.add(new ArrayList<>());
        for (int i = 0; i < root.children.size(); i++) {
            res.get(level).add(root.children.get(i).val);
        }
        for (Node next : root.children) {
            helper(next, res, level + 1);
        }
    }
}
