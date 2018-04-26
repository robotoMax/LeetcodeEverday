/**
 * just need one time, not multimple time that what's the most votes before time x.
 * We can just keep a variable max to record the global max and an arraylist. If the 
 * max change, we can clear the result arraylist, add the new name to the arraylist.Or if 
 * current votes is equals to the max, then we can add the name to the result.
 */

/**
 * If the votes is a stream, and we always need to know max votes and their names, we can use
 * LFU. Each node keeps a treemap, the key is the time, the value is an arraylist that records
 * the candidates' names. And each node have its votes number. 
 */
import java.util.*;
public class VotingSystem {
    private class Node {
        public final int votes;
        Node pre;
        Node next;
         TreeMap<Integer, List<String>> candidates;
        public Node(int votes, int time, String name, Node pre, Node next) {
            candidates = new TreeMap<>();
            this.votes = votes;
            if (!candidates.containsKey(time)) {
                candidates.put(time, new ArrayList<>());
            }
            candidates.get(time).add(name);
            this.pre = pre;
            this.next = next;
        }
    }

    Node head;
    Map<String, Node> nodeMap = new HashMap<>();

    public VotingSystem() {
        head = null;
    }

    public void addNewVote(String[] vote) {
        int time = Integer.valueOf(vote[0]);
        String name = vote[1];
        if (!nodeMap.containsKey(name)) {
            addNode(time, name);
        }
        else {
            increaseVotes(time, name);
        }
    }

    public void addNode(int time, String name) {
        if (head == null) {
            head = new Node(1, time, name, null, null);
        }
        else if (head.votes == 1) {
            head.candidates.push(time, name);
        }
        else {
            Node node = new Node(1, time, name, null, null);
            node.next = head;
            head = node;
        }
        nodeMap.put(name, head);
    }

    public void increaseVotes(int time, String name) {
        Node node = nodeMap.get(name);
        List<String> names = node.candidates.get(time);
        names.remove(name);
        if (names.isEmpty()) node.candidates.remove(time);
        if (node.next == null) {
            node.next = new Node(node.votes + 1, time, name, node, null);
        }
        else if (node.next.votes != node.votes + 1) {
            Node cur = new Node(node.votes + 1, time, name, node, node.next);
            node.next.pre = cur;
            node.next = cur;
        }
        else {
            if (!node.next.candidates.containsKey(time)) node.next.candidates.put(time, new ArrayList<>());
            node.next.candidates.get(time).add(name);
        }
        nodeMap.put(name, node.next);
        if (node.candidates.isEmpty()) removeNode(node);
    }

    public void removeNode(Node node) {
        if (node.pre == null) head = node.next;
        else {
            node.pre.next = node.next;
        }
        if (node.next != null) node.next.pre = node.pre;
    }

    public List<String> getCurMostVotes(int time) {
        List<String> res = new ArrayList<>();
        Node node = head;
        while (node.next != null) node = node.next;
        TreeMap<Integer, List<String>> map = node.candidates;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            if (entry.getKey() < time) {
                res.addAll(entry.getValue());
            }
        }
        return res;
    }

}