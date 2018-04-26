/**
 * 
 * Date: 04/16/2018
 * Created By: Shuai Liu
 * 
 * Given a linked list, find the two nodes that have the biggest value. Swap their reference.
 */
public class SwapReferenceInLinkedList {
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dum = new ListNode(Integer.MIN_VALUE);
        dum.next = head;
        ListNode f1 = dum; // biggest node's father
        ListNode f2 = dum; // second biggest's father
        ListNode b1 = head; // the biggest node
        ListNode b2 = head; // the second biggest node
        while (head != null) {
            if (head.val > b1.val) {
                while (b1 != b2) {
                    b2 = b2.next;
                    f2 = f2.next;
                }
                while (b1.val != head.val) {
                    b1 = b1.next;
                    f1 = f1.next;
                }
            }
            else if (head.val < b1.val && head.val > b2.val) {
                while (b2.val != head.val) {
                    b2 = b2.next;
                    f2 = f2.next;
                }
            }
            head = head.next;
        }
        // System.out.println(b1.val);
        // System.out.println(b2.val);
        if (b1.next == b2 || b2.next == b1) {
            if (b1.next == b2) {
                ListNode temp = b2.next;
                f1.next = b2;
                b2.next = b1;
                b1.next = temp;
            }
            else {
                ListNode temp = b1.next;
                f2.next = b1;
                b1.next = b2;
                b2.next = temp;
            }
        }
        else {
            ListNode temp = b2.next;
            f1.next = b2;
            b2.next = b1.next;
            f2.next = b1;
            b1.next = temp;
        }
        return dum.next;        
    }
    public static void main(String[] args) {
        SwapReferenceInLinkedList s = new SwapReferenceInLinkedList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(3);
        ListNode g = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = null;
        // c.next = d;
        // d.next = e;
        // e.next = f;
        // f.next = g;
        // g.next = null;
        ListNode res = s.solution(a);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}