public class LongestIncreasingPath {

    /*
    *
    * Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
    *
    *
    * */

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {

        //dfs

        //[1,1,1] if we can memo each cell, the complexity will be O(mn)

        //base case
        if(matrix.length == 0 || matrix == null) return 0;

        int[][] memo = new int[matrix.length][matrix[0].length];
        int ans = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                //traverse each node
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }

        return ans;


    }

    public int dfs(int[][] matrix, int i, int j, int[][] memo){

        if(memo[i][j] != 0) return memo[i][j];

        int m = matrix.length;
        int n = matrix[0].length;

        //four directions
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];

            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]){
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, x, y, memo));
            }
        }

        //should include the matrix(i,j)
        return ++memo[i][j];
    }


}
