package moe.tawawa.leetcode.q371_Sum_of_Two_Integers;

/**
 * @author GeeKaven
 * @date 2021/2/1 19:20
 */
public class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
