/**
 * Date: 07/17/2018
 * Created By: Shuai Liu
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
 */
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    Node pre = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dum = new Node(0, null, null);
        pre = dum;
        helper(root);
        pre.right = dum.right; // dum.right = left most point of the tree;
        dum.right.left = pre;
        return dum.right;
    }
    public void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        pre.right = root;
        root.left = pre;
        pre = root;
        helper(root.right);
    }
}