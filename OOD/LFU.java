/**
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Design and implement a data structure for Least Frequently Used (LFU) cache. 
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), 
 * the least recently used key would be evicted.

 * Follow up:
 * Could you do both operations in O(1) time complexity?

 * Example:

 * LFUCache cache = new LFUCache( 2 );

 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
*/
import java.util.*;
public class LFU {

    private class Node {
        LinkedHashSet<Integer> keys = new LinkedHashSet<>();
        public final int count;
        Node pre;
        Node next;
        public Node(int count, int key, Node pre, Node next) {
            this.count = count;
            keys.add(key);
            this.pre = pre;
            this.next = next;
        }
    }

    Map<Integer, Integer> valMap = new HashMap<>();
    Map<Integer, Node> nodeMap = new HashMap<>();
    int capacity;
    Node head;

    public LFU(int capacity) {
        this.capacity = capacity;
        head = null;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node != null) {
            increaseFreq(key);
            return valMap.get(key);
        }
        else return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (valMap.put(key, value) == null) {
            if (nodeMap.size() == capacity) {
                removeOld();
            }
            addNode(key);
        }
        else {
            increaseFreq(key);
        }
        return;
    }

    public void removeOld() {
        if (head == null) return;
        int num = head.keys.iterator().next();
        head.keys.remove(num);
        valMap.remove(num);
        nodeMap.remove(num);
    }

    public void addNode(int key) {
        if (head == null) {
            head = new Node(1, key, null, null);
        }
        else if (head.count == 1) {
            head.keys.add(key);
        }
        else {
            Node node = new Node(1, key, null, null);
            head.pre = node;
            node.next = head;
            head = node;
        }
        nodeMap.put(key, head);
    }

    public void increaseFreq(int key) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        if (node.next == null) {
            node.next = new Node(node.count + 1, key, node, null);
        }
        else if (node.next.count != node.count + 1) {
            Node cur = new Node(node.count + 1, key, node, node.next);
            node.next.pre = cur;
            node.next = cur;
        }
        else {
            node.next.keys.add(key);
        }
        nodeMap.put(key, node.next);
        if (node.keys.isEmpty()) removeNode(node);
    }

    public void removeNode(Node node) {
        if (node.pre == null) head = node.next;
        else {
            node.pre.next = node.next;
        }
        if (node.next != null) node.next.pre = node.pre;
    }

}