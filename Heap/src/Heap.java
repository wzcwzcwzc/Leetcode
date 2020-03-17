import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {

    // 最大堆

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<>(){
           @Override
           public int compare(Integer num1, Integer num2){
               return num2 - num1;
           }
        });

//        queue.add(10);
//        queue.add(5);
//        queue.add(8);
//
//        while(!queue.isEmpty()){
//            System.out.println(queue.poll());
//        }

        // 默认是最小堆，需要自己定义comparator
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(11);
        q.add(5);
        q.add(8);
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
