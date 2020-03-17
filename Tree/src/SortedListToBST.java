public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {

        //对于list node 需要取到list的中心

        //如何计算mid? 设立快慢指针

        if(head == null) return null;

        TreeNode root = buildTree(head);
        return root;

    }

    public TreeNode buildTree(ListNode head){

        //1. find the condition that the recursion finished
        if(head == null) return null;

        //2. find mid node
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);

        //3. if mid node is already equal to head, means we have reached the bottom
        //问题1：DEBUG发现边界情况不满足，增加如下条件
        if(head == mid) return root;

        root.left = buildTree(head);
        root.right = buildTree(mid.next);

        return root;

    }
    public ListNode findMid(ListNode head){

        ListNode pre_slow = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre_slow = slow;
            slow = slow.next;
        }

        //问题二：容易遗漏对于head结尾剪掉的操作
        //do cut on the list into two parts, head-pre_slow and slow-fast
        if(pre_slow != null){
            pre_slow.next = null;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
