import java.util.*;
class HashNode<K, V> {
    K key;
    V val;
    HashNode<K, V> next;
    public HashNode(K key, V val) {
        this.key = key;
        this.val = val;
    }
}

public class HashMap<K, V> {

    private List<HashNode<K, V>> bucketArray;
    private int bucketSize;
    private int size;

    public HashMap() {
        bucketArray = new ArrayList<>();
        bucketSize = 10;
        size = 0;
        for (int i = 0; i < bucketSize; i++) {
            bucketArray.add(null);
        }
    }

    public int size() {return size;}
    public boolean isEmpty() {return size() == 0;}

    private int getIndex(K key) {
        int hashcode = key.hashCode();
        int index = hashcode % bucketSize;
        return index;
    }

    public V remove(K key) {
        int index = getIndex(key);
        HashNode<K, V> head = bucketArray.get(index);
        HashNode<K, V> pre = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            pre = head;
            head = head.next;
        }
        if (head == null) return null;
        size--;
        if (pre != null) {
            pre.next = head.next;
        }
        else bucketArray.set(index, head.next);
        return head.val;
    }

    public V get(K key) {
        int index = getIndex(key);
        HashNode<K, V> head = bucketArray.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.val;
            }
            head = head.next;
        }
        return null;
    }

    public void add(K key, V val) {
        int index = getIndex(key);
        HashNode<K, V> head = bucketArray.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                head.val = val;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(index);
        HashNode<K, V> newHead = new HashNode<>(key, val);
        newHead.next = head;
        bucketArray.set(index, newHead);
        if ((1.0 * size) / bucketSize >= 0.7) {
            List<HashNode<K, V>> temp = bucketArray;
            size = 0;
            bucketSize *= 2;
            bucketArray = new ArrayList<>();
            for (int i = 0; i < bucketSize; i++) {
                bucketArray.add(null);
            }
            for (HashNode<K, V> node : temp) {
                if (node != null) {
                    add(node.key, node.val);
                    node = node.next;
                }
            }
        }
        return;
    }
    public static void main(String[] args)
    {
        HashMap<String, Integer>map = new HashMap<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        System.out.println(map.size());
        map.add("hi",5 );
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("hi"));
    }


}