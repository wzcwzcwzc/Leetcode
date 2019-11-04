import java.util.ArrayList;
import java.util.List;

public class reverseList {


    public ListNode reverse(ListNode head){

        if(head == null){
            return head;
        }

        ListNode pre = head;
        ListNode currentNode = head.next;
        ListNode temp = null;
        while(currentNode != null){
            temp = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = temp;
        }
        head.next = null;
        return pre;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l3 = new ListNode(0);
        ListNode ans = l3;
        int carrier = 0;
        int sum = 0;
        while(l1 != null || l2 != null){
            int l1_val = (l1 != null ? l1.val:0);
            int l2_val = (l2 != null ? l2.val:0);
            sum = l1_val + l2_val + carrier;
            carrier = sum / 10;
            sum = sum % 10;
            l3.val = sum;

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }

            if(l1 != null || l2 != null || carrier > 0){
                l3.next = new ListNode(carrier);
                l3 = l3.next;
            }
        }

        return ans;
    }

    public void printList(ListNode head){
        if(head == null){
            System.out.println("head is null");
        }
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        reverseList l = new reverseList();


        ListNode node1 = new ListNode(4);

        ListNode node2 = new ListNode(2);

        ListNode node3 = new ListNode(1);

        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

    }
}

class ListNode{
    ListNode next;
    int val;
    ListNode(int val){
        this.val = val;
    }
}


