/*
* Given a char array representing tasks CPU need to do.
* It contains capital letters A to Z where different letters represent different tasks.
* Tasks could be done without original order. Each task could be done in one interval.
* For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks,
* there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.



Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2 ： 代表A任务到再次执行A任务之间有n个空档
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
*
*
* */

import java.util.*;

public class TaskHandler {

    // 典型的CPU调度程序，使用优先队列和哈希表去实现任务的分配

    public int leastInterval(char[] tasks, int n) {


        // HashMap 作为cache
        HashMap<Character, Integer> map = new HashMap<>(26);

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2){
                return num2 - num1;
            }
        });

        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : map.keySet()){
            pq.add(map.get(c));
        }

        // 优先取最耗时的任务
        int res = 0;
        while(!pq.isEmpty()) {
            int count = 0;
            List<Integer> temp = new ArrayList<>();
            while (count <= n) {
                if (!pq.isEmpty()) {
                    if (pq.peek() > 1) {
                        temp.add(pq.poll() - 1);
                    } else {
                        pq.poll();
                    }
                }
                res++;
                if (pq.isEmpty() && temp.size() == 0) {
                    break;
                }
                count++;
            }
            pq.addAll(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abc";
        String c = s.substring(0, 2);
        System.out.println(String.valueOf(c.charAt(1)));

    }
}
