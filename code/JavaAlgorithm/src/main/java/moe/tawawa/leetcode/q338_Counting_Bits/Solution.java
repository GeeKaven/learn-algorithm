package moe.tawawa.leetcode.q338_Counting_Bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2021/2/1 19:54
 */
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = getBit(i);
        }
        return ans;
    }

    private int getBit(int n) {
        n = ((n >>> 1) & 0x55555555) + (n & 0x55555555);
        n = ((n >>> 2) & 0x33333333) + (n & 0x33333333);
        n = ((n >>> 4) & 0x0f0f0f0f) + (n & 0x0f0f0f0f);
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 63;
    }

    public int[] countBits1(int num) {
        int[] dp = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

    public int[] countBits2(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i / 2] + i % 2;
        }
        return dp;
    }
}
