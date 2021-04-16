package moe.tawawa.leetcode.q49_Group_Anagrams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author GeeKaven
 * @date 2021/4/16 22:34
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        Arrays.asList(strs).forEach(str -> {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String newStr = new String(temp);
            if (map.containsKey(newStr)) {
                map.get(newStr).add(str);
            } else {
                List<String> words = new ArrayList<>();
                words.add(str);
                map.put(newStr, words);
            }
        });
        List<List<String>> ans = new ArrayList<>();
        map.forEach((k, v) -> ans.add(v));
        return ans;
    }
}
