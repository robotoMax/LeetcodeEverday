/**
 * Date: 03/28/2018
 * Created By: Shuai Liu
 */
import java.util.*;
public class DisjoinSet {
    private class Node {
        Node parent;
        int data;
        int rank;
        public Node(int data, int rank, Node parent) {
            this.data = data;
            this.rank = rank;
            this.parent = parent;
        }
    }
    
    Map<Integer, Node> nodeMap = new HashMap<>();

    public void makeSet(int data) {
        Node node = new Node(data, 0, null);
        node.parent = node;
        nodeMap.put(data, node);
    }

    /**
     * combine two sets to one.
     * if return is true, then data1 and data2 are in different set befor union else false;
     */
    public boolean union(int data1, int data2) {
        Node node1 = nodeMap.get(data1);
        Node node2 = nodeMap.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        if (parent1.data == parent2.data) return false;
        if (parent1.rank >= parent2.data) {
            // increse rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        }
        else parent1.parent = parent2;
        return true;
    }

    public Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) return parent;
        node.parent = findSet(node.parent);
        return node.parent;        
    }

}