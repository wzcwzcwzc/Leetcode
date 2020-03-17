import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(10);
        d.add(5);
        d.addLast(20);

        while(!d.isEmpty()){
            System.out.println(d.poll());
        }

    }
}
