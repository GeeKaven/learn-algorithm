package moe.tawawa.leetcode.q509_Fibonacci_Number;

/**
 * @author GeeKaven
 * @date 2021/1/4 20:08
 */
public class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int fl = 0;
        int fh = 1;
        for (int i = 2; i <= n; i++) {
            int temp = fh;
            fh = fh + fl;
            fl = temp;
        }

        return fh;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(4));
    }
}
