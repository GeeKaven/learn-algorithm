package moe.tawawa.leetcode.q1143_Longest_Common_Subsequence;

/**
 * @author GeeKaven
 * @date 2021/4/12 22:47
 */
public class Solution {
    /**
     * 1. dp[i][j]  表示text1[0, i - 1]， text2[0, j - 1]
     * t[i - 1] == t[j - 1]  dp[i][j] = dp[i-1][j-1] + 1;
     * t[i - 1] != t[j - 1]  dp[i][j] = max(dp[i - 1][j], dp[i][j-1])
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[t1.length + 1][t2.length + 1];
        for (int i = 1; i <= t1.length; i++) {
            for (int j = 1; j <= t2.length; j++) {
                if(t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[t1.length][t2.length];
    }
}
