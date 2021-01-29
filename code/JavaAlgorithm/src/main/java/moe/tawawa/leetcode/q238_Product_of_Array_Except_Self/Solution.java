package moe.tawawa.leetcode.q238_Product_of_Array_Except_Self;

/**
 * @author GeeKaven
 * @date 2021/1/29 17:20
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int total = 1;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                total *= nums[i];
            }
            if (zero > 1) {
                total = 0;
                break;
            }

        }
        if (zero > 1) {
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans[i] = total;
            } else {
                if (zero > 0) {
                    ans[i] = 0;
                } else {
                    ans[i] = total / nums[i];
                }
            }
        }
        return ans;
    }

    // 乘积 = 数左边的乘积 * 数右边的乘积
    public int[] productExceptSelf1(int[] nums) {
        int[] ans = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            ans[i] = ans[i] * k;
            k = k * nums[i];
        }
        return ans;
    }
}
