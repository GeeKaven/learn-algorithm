package moe.tawawa.leetcode.q322_Coin_Change;

import java.util.Arrays;

/**
 * @author GeeKaven
 * @date 2021/4/8 23:24
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for(int coin : coins) {
            for(int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];
    }
}
