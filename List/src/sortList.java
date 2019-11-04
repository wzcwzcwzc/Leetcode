import java.util.ArrayList;
import java.util.List;

public class sortList {
    //use merge sort to divide the linkedlist and merge the result
    //merge sort can be defined as divide and merge
    //how to divide: set two pointers slow and fast then slow can move to the middle of the list


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;//将slow所在位置存储在pre内
            slow = slow.next;
            fast = fast.next.next;
        }
        //设置pre的目的就是在于截取从head到slow的部分链表
        pre.next = null;
        return merge(sortList(head), sortList(slow));
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

    }
}
