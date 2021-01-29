package moe.tawawa.leetcode.q121_Best_Time_to_Buy_and_Sell_Stock;

/**
 * @author GeeKaven
 * @date 2021/1/29 16:51
 */
public class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int max = 0;
        int pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < pre) {
                pre = prices[i];
            } else if (prices[i] - pre > max) {
                max = prices[i] - pre;
            }
        }
        return max;
    }

    /**
     * dp
     * dp[i][0] 第i天结束时，不持股
     *   昨天不持股，今天不动
     *   昨天持股，今天卖掉
     * dp[i][1] 第i天结束时，持股
     *   昨天持股，今天不动
     *   昨天不持股，今天买入
     *
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
     * dp[i][1] = max(dp[i-1][1], -price[i])
     *
     * dp[len-1][0]
     */
    public int maxProfitDP(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[len - 1][0];
    }
}
