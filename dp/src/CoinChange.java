public class CoinChange {

    /*
    * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
    *
    * */

    public int coinChange(int[] coins, int amount){

        /*
        * dp
        * use dp array to store each solution
        *
        * dp[x] = Min(dp[x], dp[x - coin(j)] + 1)
        * we need to traverse coin array
        *
        *
        * suppose x = 11, if we choose one 5 coin, the rest is dp[6], so
        * the total coin number is dp[11-coin(5)]+1 = dp[6]+1
        * */
        if (coins.length == 0) return -1;

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            dp[i] = amount + 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < coins.length; j++) {
                //if amount >= j, which means we need one coin or more than one coin
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }


    //test: [1, 2] amount=3
    //dp=[0,4,4,4]
    /*
    * i=1
    * dp[1] = min(dp[1], dp[1-1]+1)
    *
    * */
}
