package moe.tawawa.leetcode.q191_Number_of_1_Bits;

/**
 * @author GeeKaven
 * @date 2021/2/1 19:33
 */
public class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        while(n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }
}
