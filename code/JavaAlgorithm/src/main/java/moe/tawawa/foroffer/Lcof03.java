package moe.tawawa.foroffer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geekaven
 * @date 2020/6/10 11:26 AM
 *
 * link : https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 */
public class Lcof03 {
    public int findRepeatNumber(int[] nums) {
        int res = -1;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = numMap.getOrDefault(num, 0);
            if (count > 0) {
                res = num;
                break;
            } else {
                numMap.put(num, count + 1);
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] test = {2, 3, 1, 0, 2, 5, 3};
        int res = findRepeatNumber(test);
        Assertions.assertEquals(2,res);
    }
}
