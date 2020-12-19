package moe.tawawa.foroffer;

/**
 * @author geekaven
 * @date 2020/6/10 11:54 AM
 */
public class Lcof10 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = (f[i-1] + f[i-2]) % 1000000007;
        }
        return f[n];
    }

    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i-1] + f[i-2]) % 1000000007;
        }
        return f[n];
    }
}
