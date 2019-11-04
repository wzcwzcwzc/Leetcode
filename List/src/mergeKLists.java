import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> temp = new ArrayList<>();
        ListNode ans = null;

        for(int i = 0; i < lists.length; i++){
            ListNode current = lists[i];
            while(current != null){
                temp.add(current.val);
                current = current.next;
            }
        }

        Object[] arr = temp.toArray();
        Arrays.sort(arr);
        ListNode dump = new ListNode(-1);
        ListNode current = dump;

        //build linked list
        for(int i = 0; i < arr.length; i++){
            current.next = new ListNode((int)arr[i]);
            current = current.next;
        }

        return dump.next;
    }

    public ListNode mergeKLists_2(ListNode[] lists){
         ListNode ans = null;

         if(lists.length == 0) return null;

         if(lists.length == 1){
             //only one list
             return lists[0];
         }

         ans = merge(lists[0], lists[1]);


         //use merge sort O(nlogn)
         for(int i = 2; i < lists.length; i++){
             ans = merge(ans, lists[i]);
         }

         return ans;
    }


    public ListNode merge(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(-2);
        ListNode current = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 != null){
            current.next = l1;
        }

        if(l2 != null){
            current.next = l2;
        }
        return dummy.next;
    }
}
