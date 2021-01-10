package moe.tawawa.leetcode.q228_Summary_Ranges;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2021/1/10 20:43
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length <= 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        int index = 0;
        while (index < nums.length) {
            int begin = nums[index];

            StringBuilder sb = new StringBuilder();
            sb.append(begin);
            int plus = 0;
            while (index < nums.length && nums[index] == begin + plus) {
                index++;
                plus++;
            }
            int end = nums[index - 1];
            if (begin != end) {
                sb.append("->");
                sb.append(end);
            }

            ans.add(sb.toString());
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.summaryRanges(new int[] {0,2,3,4,6,8,9}).forEach(System.out::println);
    }
}
