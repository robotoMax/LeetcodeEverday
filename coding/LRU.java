import java.util.*;
public class LRU {
    private class Node {
        Node pre;
        Node next;
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }
    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            removeNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, val);
            if (capacity == 0) {
                removeNode(tail.pre);
                capacity++;
            }
            addNode(node);
            capacity--;
        }
        else {
            removeNode(node);
            node = new Node(key, val);
            addNode(node);
        }
        return;
    }

    public void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
        map.remove(node.key);
        node = null;
    }

    public void addNode(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
        map.put(node.key, node);
    }

}