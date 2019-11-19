public class ReverseBetween {

    /*
    * Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
    *
    * */


    //iterate the whole list and find list between m and n

    //use pre, current, temp to do reverse

    //bound case: if the first node is m, we need to make sure the
    //first element can also be m, so we need to set dummy node


    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        //do not forget connect dummy with head
        dummy.next = head;
        ListNode pre = dummy;

        for(int i  = 0; i < m - 1; i++){
            pre = pre.next;
        }

        //after find the position m then we can set current index
        ListNode current = pre.next;
        for(int i = m; i < n; i++){
            //reverse
            //1-2-3-4 m=2, n=3
            //p c t
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummy.next;
    }
}
