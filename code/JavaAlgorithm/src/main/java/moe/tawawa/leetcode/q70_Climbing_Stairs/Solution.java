package moe.tawawa.leetcode.q70_Climbing_Stairs;

/**
 * @author GeeKaven
 * @date 2021/4/8 23:15
 */
public class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] step = new int[n + 1];
        step[1] = 1;
        step[2] = 2;
        for (int i = 3; i <= n; i++) {
            step[i] = step[i - 1] + step[i - 2];
        }
        return step[n];
    }
}
