package moe.tawawa.leetcode.q217_Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author GeeKaven
 * @date 2021/1/29 17:01
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
