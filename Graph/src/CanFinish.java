import java.util.*;

public class CanFinish {


    /*
    *
    * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
    *
    *
    *
    * */


    /*
    *
    * 选择一个没有前驱的节点（入度为0的点）
    *
    * 从图中删除该顶点以及所有以它为起点的有向边
    *
    * 直到Queue中没有无前驱的点为止，如果有则说明存在环
    *
    * [1,0] ->  0 -> 1
    *
    * */


    //topology sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] in = new int[numCourses];

        for(int[] pair : prerequisites){
            //preCourse needs first finish curCourse
            int pre = pair[1];
            int cur = pair[0];
            List<Integer> nextCourses = graph.getOrDefault(pre, new ArrayList<>());
            nextCourses.add(cur);
            graph.put(pre, nextCourses);
            //in degree = n, it means there are n edges point to the node
            in[cur]++;
        }

        //topo sort
        Queue<Integer> todo = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(in[i] == 0){
                todo.add(i);
            }
        }

        int count = 0;

        while(!todo.isEmpty()){
            int cur = todo.remove();
            count++;

            for(int next : graph.getOrDefault(cur, new ArrayList<>())){
                //in degree is 0, it means the node is finished
                in[next]--;
                if(in[next] == 0){
                    todo.add(next);
                }
            }

        }
        return count == numCourses;
    }

    //topo sort with dfs
    //create graph and use stack to store the result
    public boolean canFinishWithDFS(int numCourses, int[][] prerequisites) {

        //1. build up graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pair : prerequisites) {
            if(!graph.containsKey(pair[0])){
                graph.put(pair[0], new HashSet<>());
            }
            graph.get(pair[0]).add(pair[1]);
        }
        //2. use set visited to mark the node is visited or not
        Set<Integer> visit = new HashSet<>();
        //3. use dfs to traverse the whole graph and find whether
        //there is conflict between visited node and new node
        for(Integer key : graph.keySet()){
            visit.add(key);
            for(Integer adj : graph.get(key)){
                if(!explore(graph, adj, visit)){
                    return false;
                }
            }
            visit.remove(key);
        }
        return true;
    }

    public boolean explore(Map<Integer, Set<Integer>> graph, Integer key, Set<Integer> visit){
        visit.add(key);
        if(graph.containsKey(key)){
            for(Integer adj : graph.get(key)){
                if(visit.contains(adj)){
                    return false;
                }
                if(!explore(graph, adj, visit)){
                    return false;
                }
            }
        }
        visit.remove(key);
        return true;
    }
}
