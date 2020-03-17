import java.util.Arrays;
import java.util.PriorityQueue;

// cpu process handle (greedy)

public class MaxEvents {

    public int maxEvents(int[][] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, n = A.length;
        for (int d = 1; d <= 100000; ++d) {
            while (i < n && A[i][0] == d) {
                pq.offer(A[i++][1]);
            }
            while (pq.size() > 0 && pq.peek() < d) {
                pq.poll();
            }
            if (pq.size() > 0) {
                pq.poll();
                ++res;
            }
        }
        return res;
    }
}
