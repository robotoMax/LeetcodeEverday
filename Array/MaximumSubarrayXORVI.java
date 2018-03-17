public class MaximumSubarrayXORVI {

    private class Node {
        public int val;
        public Node[] child;
        public Node(int val) {
            this.val = val;
            child = new Node[2];
        }
    }

    public void buildTree(Node root, int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = num >> i & 1;
            if (node.child[bit] == null) node.child[bit] = new Node(bit);
            node = node.child[bit];
        }
    }

    public int maxXorSubarray(int[] nums) {

    }
}