package moe.tawawa.leetcode.q242_Valid_Anagram;

/**
 * @author GeeKaven
 * @date 2021/4/16 22:12
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] word = new int[26];
        for (int i = 0; i < s.length(); i++) {
            word[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            word[t.charAt(i) - 'a']--;
            if (word[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
