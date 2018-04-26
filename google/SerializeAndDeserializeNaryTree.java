import java.util.*;
public class SerializeAndDeserializeNaryTree {

    private static class Node {
        int key;
        List<Node> child;
        public Node(int c) {
            key = c;
            child = new ArrayList<>();
        }
    }

    public String serialize(Node root) {
        String res = "";
        res += root.key;
        if (root == null || root.child.size() == 0) return res + "," + "#";
        for (Node next : root.child) {
            res += "," + serialize(next);
        }
        res += ",#";
        return res;
    }

    public Node deserialize(String str) {
        if (str == null || str.length() == 0) return null;
        String[] strs = str.split(",");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(strs));
        return helper(queue);
    }

    public Node helper(Queue<String> queue) {
        String str = queue.poll();
        Node root = new Node(Integer.parseInt(str));
        while (!queue.isEmpty() && !queue.peek().equals("#")) {
            root.child.add(helper(queue));
        }
        queue.poll();
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeNaryTree s = new SerializeAndDeserializeNaryTree();
        Node root = new Node(0);
        Node c1 = new Node(1);
        Node c2 = new Node(2);
        Node c3 = new Node(3);
        Node c4 = new Node(4);
        Node c11 = new Node(11);
        root.child.add(c1);
        root.child.add(c2);
        root.child.add(c3);
        root.child.add(c4);
        c1.child.add(c11);
        String str = s.serialize(root);
        System.out.println(str);
        System.out.println(s.deserialize(str).key); 
        for (Node n : s.deserialize(str).child) System.out.println(n.key);      
    }
}
