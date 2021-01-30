package moe.tawawa.leetcode.q15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2021/1/30 19:16
 */
public class Solution {
    // 先排序
    // 遍历数组
    // 对于每一个数，取后一位L，最后一位R 相加等于0即为一个解
    // sum > 0, 表示加多了，R--
    // sum < 0, 表示减多了，L++
    // 当num[i] > 0时，后面的数不可能相加为0，直接结束
    // 去重
    // num[i] == num[i-1]时，直接跳过
    // num[L+1] == num[L]时，找到不相等为止
    // num[R-1] == num[R]时，找到不相等为止
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3) {
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[L], nums[R])));
                    while (L < R && nums[L + 1] == nums[L]) {
                        L++;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else{
                    L++;
                }
            }
        }
        return ans;
    }
}
