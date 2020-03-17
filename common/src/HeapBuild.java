import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapBuild {



    public static void main(String[] args) {

        //use priority queue
        int size = 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>(size, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });

        pq.add(10);
        pq.add(6);
        pq.add(12);

        System.out.println(pq.peek());

        //minHeap o1-o2 smallest element is on top of heap
        //maxHeap o2-o1 biggest element is on top of heap

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
}
