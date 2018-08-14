import java.util.*;
public class SerializeAndDeserializeNaryTree {

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public String serialize(Node root) {
        if (root == null) return "";
        String res = helper(root);
        return res;
    }
    
    public String helper(Node root) {
        String res = "";
        res += root.val;
        if (root == null || root.children.size() == 0) return res + ",#";
        for (Node node : root.children) {
            res += "," + helper(node);
        }
        res += ",#";
        return res;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strs = data.split(",");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(strs));
        return helper1(queue);
    }
    
    public Node helper1(Queue<String> queue) {
        String cur = queue.poll();
        Node root = new Node(Integer.parseInt(cur), new ArrayList<>());
        while (!queue.isEmpty() && !queue.peek().equals("#")) {
            root.children.add(helper1(queue));
        }
        queue.poll();
        return root;
    }
}
