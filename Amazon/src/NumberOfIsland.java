public class NumberOfIsland {


    /*
    * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    *  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    *  You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
    *
    *
    * */

    public int numIslands(char[][] grid) {

        //base case
        if(grid == null || grid.length == 0) return 0;


        //use dfs to traverse the whole maze
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;

        //traverse whole matrix with for loop
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1') {
                    //find the start point and then do dfs to search other points
                    num++;
                    dfs(grid, r, c);
                }
            }
        }

        return num;
    }

    public void dfs(char[][] grid, int r, int c){

        //if it is out of bound or grid[r][c] is already visited, we need to return
        int row = grid.length;
        int col = grid[0].length;

        if(r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == '0') return;
        //if it is not visited then we need to set grid[r][c] = '0', then do dfs on four directions
        grid[r][c] = '0';
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r,c+1);
        dfs(grid, r,c-1);
    }

    //same problem is 463.Island perimeter

}
