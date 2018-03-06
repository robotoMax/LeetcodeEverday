/**
 * 
 * Date: 03/05/2018
 * Created By: Shuai Liu
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 */
import java.util.*;
public class MergeKSortedLists {
    public ListNode solution(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) heap.add(lists[i]);
        }
        ListNode dum = new ListNode(0);
        ListNode newHead = dum;
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            if (cur.next != null) {
                heap.add(cur.next);
            }
            dum.next = cur;
            dum = dum.next;
        }
        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
