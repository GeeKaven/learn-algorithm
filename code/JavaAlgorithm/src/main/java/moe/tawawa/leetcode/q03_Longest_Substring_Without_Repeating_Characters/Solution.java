package moe.tawawa.leetcode.q03_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GeeKaven
 * @date 2020/12/20 15:47
 *
 * keys： 滑动窗口
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (left < s.length()) {
            if (right < s.length() && map.getOrDefault(s.charAt(right), 0) <= 0) {
                map.put(s.charAt(right), 1);
                right++;
            } else {
                map.put(s.charAt(left), 0);
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    /**
     * 解法2： 保存出现字符的下标，后续如果重复，直接从曾经出现的字符的下标+1，可以减少一些步骤
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring2("abcabcbb"));
    }
}
