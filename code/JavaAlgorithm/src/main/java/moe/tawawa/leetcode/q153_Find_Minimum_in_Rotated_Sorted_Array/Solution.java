package moe.tawawa.leetcode.q153_Find_Minimum_in_Rotated_Sorted_Array;

/**
 * @author GeeKaven
 * @date 2021/1/30 19:02
 */
public class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > pre) {
                pre = nums[i];
            } else {
                min = nums[i];
                break;
            }
        }
        return min;
    }

    public int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] <= nums[right]) {
            return nums[0];
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
