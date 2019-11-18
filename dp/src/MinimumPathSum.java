public class MinimumPathSum {


    /*
    * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
    *
    * */

    public int minPathSum(int[][] grid) {

        //kind of search problem and optimize problem
        //dp O(m*n)

        //bound constrain, initialize the bound

        //we can use grid to store the dp value instead of creating new dp[][]
        //and the space can be optimized to O(1)

        //dp[i][j] = Min(dp[i-1][j], dp[i][j-1]) + grid(i,j)
        //dp[0][0] = grid[0][0]

        if(grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        //initialize the bound of array
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }


        return dp[m-1][n-1];

    }
}
