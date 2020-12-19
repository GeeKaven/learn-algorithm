package moe.tawawa.leetcode.q01_Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GeeKaven
 * @date 2020/12/19 16:45
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer rIndex = numMap.get(target - nums[i]);
            if (rIndex != null) {
                res[0] = rIndex;
                res[1] = i;
            }
            numMap.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 3};
        int[] res = solution.twoSum(nums, 6);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
