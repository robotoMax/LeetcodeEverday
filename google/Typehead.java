import java.util.*;
// if we need to update, we also need a hashmap. Key is the str, value is Data object. Then we can find it and delete it then update it.
public class Typehead {

    private class Node {
        Node[] child = new Node[26];
        PriorityQueue<Data> strs = new PriorityQueue<>((a, b) -> Integer.compare(b.weight, a.weight));
        public Node() {}
        public Node(Data data) {
            strs.add(data);
        }
    }

    private class Data {
        int weight;
        String word;
        public Data(int count, String word) {
            this.weight = count;
            this.word = word;
        }
    }

    Node root;
    public Typehead(Map<String, Integer> stringsAndWeight) {
        root = new Node();
        buildTree(root, stringsAndWeight);
    }

    public void buildTree(Node root, Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Node node = root;
            String str = entry.getKey();
            int weight = entry.getValue();
            for (char c : str.toCharArray()) {
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new Node();
                }
                Data data = new Data(weight, str);
                node.child[c - 'a'].strs.add(data);
                node = node.child[c - 'a'];
            }
        }
    }

    public List<String> suggestion(String str) {
        Node node = root;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            node = node.child[str.charAt(i) - 'a'];
            if (node == null) return res;
        }
        for (Data d : node.strs) {
            res.add(d.word);
        }
        return res;
    }

}
