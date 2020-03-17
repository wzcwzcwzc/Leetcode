import java.util.Arrays;
import java.util.PriorityQueue;

public class ArraysSort {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // greedy + priorityqueue
        //first sort by efficiency then by speed
        final int MOD = (int) (1e9 + 7);

        int[][] com = new int[n][2];

        // initial the array
        for(int i = 0; i < speed.length; i++){
            com[i][0] = speed[i];
            com[i][1] = efficiency[i];
        }

        // get max efficiency at com[0][1]
        Arrays.sort(com, (a, b) -> (b[1] - a[1]));

        // store minimal speed
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> (a - b));
        long res = Long.MIN_VALUE;
        long total_speed = 0;

        for(int[] temp : com){
            if(pq.size() == k){
                total_speed -= pq.poll();
            }
            pq.add(temp[0]);
            total_speed += temp[0];
            // current min(efficiency) is temp[1]
            res = Math.max(res, total_speed * temp[1]);
        }

        return (int) (res % MOD);
    }


    public static void main(String[] args) {
        int[][] com = {{1,3}, {1,4}};
        //从小到大
        Arrays.sort(com, (a, b) -> (b[1] - a[1]));

        for(int[] t : com){
            System.out.println(t[0] + " " + t[1]);
        }

        int size = 10;
        PriorityQueue<Integer> pq = new PriorityQueue<>(size, (a, b) -> a - b);
        int total_speed = 0;
        int res = 0;
        for(int[] c : com){
            if(pq.size() == size){
                total_speed = total_speed - pq.poll();
            }
            // store the speed
            pq.add(c[1]);
            total_speed = total_speed + c[1];
            res = Math.max(res, total_speed * c[0]);
        }

    }
}
