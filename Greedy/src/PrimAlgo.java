public class PrimAlgo {


    public final static int INF = Integer.MAX_VALUE;

    int[][] graph;
    boolean[] visited;

    // initialize a graph by using array

    public int Prim(int start){

        int sum = 0;

        /*
        * 1 -- 2 : 3
        * 1 -- 3 : 2
        * 2 -- 4 : 4
        * */

        graph = new int[][]{
                {INF, 3, 2, INF},
                {3, INF, INF, 4},
                {2, INF, INF, INF},
                {INF, 4, INF, INF}
        };

        visited = new boolean[graph.length];
        visited[start] = true;
        int index = start;

        // dist记录了出发节点到其他节点的最短距离，需要不断的更新
        int[] dist = new int[graph.length];


        // initialize the start point
        for(int i = 0; i < dist.length; i++){
            dist[i] = graph[start][i];
        }


        for (int i = 1; i < graph.length; i++){
            int min = Integer.MAX_VALUE;

            for(int j = 0; j < dist.length; j++){

                if(!visited[j] && dist[j] < min){
                    // update the min and index
                    min = dist[j];
                    index = j;
                }
            }

            visited[index] = true;
            sum = sum + min;

            // update the distance of start node to other node
            // 更新出发节点到其他节点的距离，1-3访问了，此时节点更新为3，如果1-2未访问过，但是1-2的距离大于3-2的距离
            // 那就需要更新1-2的距离，改成从3-2的距离（贪心）
            for(int k = 0; k < visited.length; k++){
                // if dist[k] > graph[index][k], update
                if(!visited[k] && dist[k] > graph[index][k]){
                    dist[k] = graph[index][k];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        PrimAlgo p = new PrimAlgo();
        int ans = p.Prim(0);
        System.out.println(ans);

    }
}
