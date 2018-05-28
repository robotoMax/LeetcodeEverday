/**
 * 
 * Date: 03/27/2018
 * Created By: Shuai Liu
 * 
 * You are given a double linked list and an array of references to nodes on the linked list.
 * How many groups are there present in the linked list?
 * 
 * [node #0] -><- [node #1] -><- [node #2] -><- [node #3]
 * Node[] nodes = {node#0, node#2, node#3}
 * it should return 2.
 * 
 */
/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
import java.util.*;
public class FindDoubleLinkedListGroup {
    public int solution(Node[] nodes) {
        int res = 0;
        Set<Node> set = new HashSet<>();
        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            res++;
            if (set.contains(node.pre)) res--;
            if (set.contains(node.next)) res--;
            set.add(node);
        }
        return res;
    }
}
/**
 * Created By: Shuai Liu
 * 请勿作为商业用处。尊重劳动成果
 */
class Node {
    int val;
    Node pre;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}