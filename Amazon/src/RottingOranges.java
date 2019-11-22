import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {



    /*
    *
    * In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
    *
    * */

    int[][] directions  = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {


        //use bfs but not dfs because we need to traverse
        //inside to outside
        //create timeCount to count the time
        if(grid == null || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        //use int[]{i,j} to represent the condition of grid[i][j]
        //we can also use map to represent the relationship of i and j
        Queue<int[]> q = new LinkedList<>();

        //find the start points which is rotted orange
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int timeCount = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] pos = q.poll();
                //check four directions
                for(int[] dir : directions){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1){
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                    }
                }
            }
            timeCount++;
        }

        //check whether there is still fresh orange
        for(int i = 0; i < m ;i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return timeCount - 1;
    }

}
