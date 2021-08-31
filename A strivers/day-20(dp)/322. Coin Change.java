/*
322. Coin Change
Medium

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
Accepted
731,338
Submissions
1,893,921

link --> https://leetcode.com/problems/coin-change/
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int amt = 0; amt < amount + 1; amt++)
            for (int coin: coins)
                if (amt - coin >= 0) dp[amt] = Math.min(dp[amt - coin] + 1, dp[amt]);
                else break;

        return (dp[amount] <= amount) ? dp[amount] : -1;
    }
}
