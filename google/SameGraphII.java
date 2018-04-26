public class SameGraphII {

    class Node {
        int val;
        LinkedList<Node> adj;

        public Node(int v) {
            this.val = v;
            adj = new LinkedList<>();
        }
    }


    public boolean isSameGraph(Node n1, Node n2) {
        return isSameGraph(n1, n2, new HashSet<Node>(), new HashSet<Node>());
    }

    public boolean isSameGraph(Node n1, Node n2, HashSet<Node> visited1, HashSet<Node> visited2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null || n1.val != n2.val || n1.adj.size() != n2.adj.size()) {
            return false;
        }

        if (visited1.contains(n1) && visited2.contains(n2)) {
            return true;
        }
        if (visited1.contains(n1) || visited2.contains(n2)) {
            return false;
        }
        visited1.add(n1);
        visited2.add(n2);
        HashMap<Integer, Node> map1 = new HashMap<>();
        HashMap<Integer, Node> map2 = new HashMap<>();
        for (Node n : n1.adj) {
            map1.put(n.val, n);
        }
        for (Node n : n2.adj) {
            map2.put(n.val, n);
        }
        for (Node a1 : n1.adj) {
            if (!map2.containsKey(a1.val)) {
                return false;
            }
            if (!isSameGraph(a1, map2.get(a1.val), visited1, visited2)) {
                return false;
            }
        }
        return true;
    }
}
