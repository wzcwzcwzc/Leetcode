import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {

    /*
    *
    * 1-2-3
    * 2-1
    * 3-1
    *
    * */

    //number of vertex
    int V;

    LinkedList<Integer> adj[];

    Graph(int v){
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0 ; i < v; i++){
            adj[i] = new LinkedList<>();

        }
    }

    public void addEdge(int v1, int v2){
        adj[v1].add(v2);
    }

}


class main {


    //use recursion to traverse each node in graph
    public void topoUtil(Graph g, int v, boolean[] visited, Stack stack){

        //set as visited
        visited[v] = true;

        //use v as the root and dfs search other nodes
        Iterator<Integer> iterator = g.adj[v].iterator();
        while(iterator.hasNext()){
            int k = iterator.next();
            if(!visited[k]){
                topoUtil(g, k, visited, stack);
            }
        }

        //if all the nodes are visited, add the node into stack
        stack.add(v);
    }

    public void topoSort(Graph g){

        //use stack to store the result node
        Stack<Integer> stack = new Stack<>();

        //initial it with false
        boolean[] visited = new boolean[g.V];

        for(int i = 0; i < g.V; i++){
            //iterate whole vertex in the graph
            if(!visited[i]){
                topoUtil(g, i, visited, stack);
            }
        }

        //output the sort result
        while(!stack.isEmpty()){
            System.out.println(stack.pop() + " ");

        }
    }




    public static void main(String[] args) {

        Graph g = new Graph(6);
        main m = new main();
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        m.topoSort(g);


    }
}


