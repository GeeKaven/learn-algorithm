package moe.tawawa.leetcode.q26_Remove_Duplicates_from_Sorted_Array;

/**
 * @author GeeKaven
 * @date 2021/7/6 22:38
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        int q = 0;
        while(q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p+1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
