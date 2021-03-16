package moe.tawawa.leetcode.q424_Longest_Repeating_Character_Replacement;

/**
 * @author GeeKaven
 * @date 2021/3/16 23:13
 */
public class Solution {
    public int characterReplacement(String s, int k) {

        if(s == null) {
            return 0;
        }

        int[] map = new int[26];
        int left = 0;
        int right = 0;
        int max = 0;
        char[] chars = s.toCharArray();

        for(right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            max = Math.max(max, map[index]);
            if(right - left + 1 > max + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }

        return right - left;
    }
}
