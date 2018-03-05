/*
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: 
 * get and put.

 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
*/
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
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
        this.capacity = capacity;
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
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (capacity == 0) {
                removeNode(tail.pre);
                capacity++;
            }
            addNode(node);
            capacity--;
        }
        else {
            removeNode(node);
            node = new Node(key, value);
            addNode(node);
        }
        return;
    }
    
    public void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
        map.remove(node.key);
    }
    
    public void addNode(Node node) {
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
        map.put(node.key, node);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */