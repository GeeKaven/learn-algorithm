package moe.tawawa.leetcode.q07_Reverse_Integer;

/**
 * @author GeeKaven
 * @date 2020/12/20 23:25
 */
public class Solution {
    public int reverse(int x) {
        boolean positive = x > 0;
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (positive && res > Integer.MAX_VALUE) return 0;
        if (!positive && res < Integer.MIN_VALUE) return 0;
        return (int)res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-15342));
    }
}
