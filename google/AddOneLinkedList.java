/**
 * 
 * Date: 03/21/2018
 * Created By: Shuai Liu
 * 
 * 用链表模拟数字+1的操作
 */
import java.util.*;
public class AddOneLinkedList {
    public ListNode solution(ListNode head) {
        if (head == null) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
        }
        ListNode dum = new ListNode(0);
        dum.next = head;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = dum.next;
        while (!stack.isEmpty()) {
            ListNode cur = stack.pop();
            if (cur.val < 9) {
                cur.val += 1;
                return head;
            }
            else cur.val = 0;
        }
        if (head.val == 0) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            dum.next = newHead;
        }
        return dum.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = null;
        AddOneLinkedList add = new AddOneLinkedList();
        ListNode res = add.solution(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

class ListNode {
    ListNode next;
    int val;
    public ListNode(int val) {this.val = val;}
}