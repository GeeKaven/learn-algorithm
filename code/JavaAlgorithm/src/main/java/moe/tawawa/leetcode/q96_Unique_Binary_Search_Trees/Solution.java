package moe.tawawa.leetcode.q96_Unique_Binary_Search_Trees;

/**
 * @author GeeKaven
 * @date 2020/12/26 21:04
 */
public class Solution {
    // 0 ~ n 以每一个数为根节点BST的和
    // F(0) = 1
    // F(1) = 1
    // F(2) = 2
    // F(3) = F(0) * F(2) + F(1) * F(1) + F(2) * F(0)
    // F(4) = F(0) * F(3) + F(1) * F(2) + F(2) * F(1) + F(3) * F(0)
    //
    // 卡特兰数
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }
        int[] F = new int[n + 1];
        F[0] = 1;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                F[i] += F[j] * F[i - j - 1];
            }
        }
        return F[n];
    }
}
