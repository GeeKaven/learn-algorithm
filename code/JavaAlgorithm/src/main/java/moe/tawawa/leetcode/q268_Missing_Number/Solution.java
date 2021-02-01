package moe.tawawa.leetcode.q268_Missing_Number;

/**
 * @author GeeKaven
 * @date 2021/2/1 20:23
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int miss = nums.length;
        for (int i = 0; i < nums.length; i++) {
            miss = miss ^ ( i ^ nums[i]);
        }
        return miss;
    }
}
