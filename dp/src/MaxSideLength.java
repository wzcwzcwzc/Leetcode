public class MaxSideLength {

    /*Given a m x n matrix mat and an integer threshold. Return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.



Example 1:
[1 1 3 2 4 3 2
 1 1 3 2 4 3 2
 1 1 3 2 4 3 2]

 左上角四个元素组成了第一个样例答案

Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
Output: 2
Explanation: The maximum side length of square with sum less than 4 is 2 as shown.
Example 2:

Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
Output: 0
Example 3:

Input: mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
Output: 3
Example 4:

Input: mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
Output: 2
    *
    * */


    //对于重叠部分元素的计算，找出状态转移方程
    public int maxSideLength(int[][] mat, int threshold) {

        //dynamic programming
        //dp[i][j] 从左上角到右下脚

        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                //keep compare and find best solution, use k to increase the area of square
                for(int k = 0; i + k <= n && j + k <= m; k++){
                    int sum = dp[i + k][j + k] - dp[i + k][j - 1] - dp[i - 1][j + k] + dp[i - 1][j - 1];
                    if(sum > threshold){
                        break;
                    }
                    ans = Math.max(ans, k + 1);
                }
            }
        }

        return ans;


    }

}
