// time O(n^2)
import java.util.*;
public class PlaylistCluster {
    Map<Integer, Node> nodeMap = new HashMap<>();
    public int solution(List<List<Integer>> playlists) {
        if (playlists == null || playlists.size() == 0) return 0;
        int res = playlists.size();
        for (int i = 0; i < playlists.size(); i++) {
            makeNode(i, playlists.get(i));
        }
        for (int i = 0; i < playlists.size() - 1; i++) {
            Node n1 = nodeMap.get(i);
            for (int j = i + 1; j < playlists.size(); j++) {
                Node n2 = nodeMap.get(j);
                Node p2 = find(n2);
                Node p1 = find(n1);
                // System.out.println("p1 id: " + p1.id + " p2 id: " + p2.id);
                // if they are already in the same cluster or if they can be union together, result should minus 1;
                if (p1.equals(p2)) continue;
                if (union(i, j)) res--;
            }
        }
        // for (int i = 0; i < 4; i++) {
        //     Node p = find(nodeMap.get(i));
        //     System.out.println(p.id);
        // }
        return res;
    }
    public void makeNode(int index, List<Integer> l) {
        Node node = new Node(null, l);
        node.parent = node;
        nodeMap.put(index, node);
        node.id = index;
    }
    public Node find(Node node) {
        Node par = node.parent;
        while (par != par.parent) {
            par = par.parent;
        }
        return par;
    }
    // i and j are two indexes
    public boolean union(int i, int j) {
        Node n1 = nodeMap.get(i);
        Node n2 = nodeMap.get(j);
        Set<Integer> v1 = n1.videos;
        Set<Integer> v2 = n2.videos;
        if (v1.containsAll(v2)) {
            n2.parent = n1;
            return true;
        }
        else if (v2.containsAll(v1)) {
            n1.parent = n2;
            return true;
        }
        return false;
    }

    // follow up: 优化：

    public static void main(String[] args) {
        PlaylistCluster p = new PlaylistCluster();
        List<List<Integer>> playList = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        l1.addAll(Arrays.asList(new Integer[] {1,2,4,5}));
        l2.addAll(Arrays.asList(new Integer[] {2,6}));
        l3.addAll(Arrays.asList(new Integer[] {3}));
        l4.addAll(Arrays.asList(new Integer[] {5}));
        playList.add(l1);
        playList.add(l2);
        playList.add(l3);
        playList.add(l4);
        System.out.println(p.solution(playList));
    }
}

class Node {
    Node parent;
    int id;
    Set<Integer> videos = new HashSet<>();
    public Node(Node parent, List<Integer> video) {
        videos.addAll(video);
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || (getClass() != o.getClass())) return false;
        Node obj = (Node) o;
        return obj.id == this.id;
    }
}