package moe.tawawa.leetcode.q300_Longest_Increasing_Subsequence;

import java.util.Arrays;

/**
 * @author GeeKaven
 * @date 2021/4/10 23:49
 */
public class Solution {
    // dp[i] 表示nums从0到i的最长递增子序列长度
    // j [0, i)
    // 当dp[i] > dp[j] 时 dp[i] = max(dp[i], dp[j]+1)
    // 每循环一轮 res = max(res, dp[i])
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
