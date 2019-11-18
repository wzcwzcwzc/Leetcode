import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {



    /*
    * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
    *
    *
    *
    * Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
    * */


    public Node copyRandomList(Node head) {

        //use hashmap to store the whole relationship in list
        Map<Node, Node> cloneMap = new HashMap<>();

        //first iterate to store each node in hashmap but we should not change head
        Node curr = head;
        while(curr != null){
            cloneMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        //second is to set up random pointers by get node from hashmap
        //set curr back to head
        curr = head;
        while(curr != null){
            //connect curr with curr.next so that finish next pointer connection
            cloneMap.get(curr).next = cloneMap.get(curr.next);
            //finish random pointers connection
            cloneMap.get(curr).random = cloneMap.get(curr.random);

            //update curr
            curr = curr.next;
        }

        //last step: return map.get(head) and now the head is connected with each nodes
        return cloneMap.get(head);
    }
}


class Node{
    public int val;
    public Node next;
    public Node random;

    public Node(int val){}

    public Node(int val, Node next, Node random){

        this.val = val;
        this.next = next;
        this.random = random;

    }
}
