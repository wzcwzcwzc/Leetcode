import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        map = new HashMap<>();
        //the capacity means capacity of hashMap
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {

        //1. judge whether the key is in hashmap or not
        Node node = map.get(key);

        if(node == null) return -1;

        if(node != tail){
            //if the node is in hashmap but not be the tail, we need to move it to tail
            //at first, we need to remove the node, then add it to tail
            if(node == head){
                head = head.next;
            }else{
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }

            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }

        return node.val;

    }

    public void put(int key, int value) {

        //1. check whether the node is already in map
        //if the node is exists in map, we need to move it to tail, the same as get

        Node node = map.get(key);
        if(node != null){
            node.val = value;

            if(node != tail){
                if(node == head){
                    head = head.next;
                }else{
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }

                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;

            }
        }else{
            //if we cannot find the node in map, we need to insert the node
            //and put it into tail
            Node newNode = new Node(key, value);
            //check the capacity, it equals 0 means it is full,
            //and we need to evict the least used element
            if(capacity == 0){
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }

            //newNode become head
            if(head == null && tail == null){
                head = newNode;
            }else{
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }

            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }
}

class Node{

    Node pre;
    Node next;
    int key;
    int val;

    Node(int key, int val){
        this.key = key;
        this.val = val;
    }

}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */