package moe.tawawa.leetcode.q152_Maximum_Product_Subarray;

/**
 * @author GeeKaven
 * @date 2021/1/29 18:02
 */
public class Solution {
    public int maxProduct(int[] nums) {

        int ans = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            ans = Math.max(ans, imax);
        }
        return ans;
    }

    // 最小的积有可能乘以当前数变成最大的
    // 因此需要保存最小的乘积
    // maxDP[i] = max(maxDP[i-1] * num[i], num[i], minDP[i-1] * num[i])
    // minDP[i] = min(minDP[i-1] * num[i], num[i], maxDP[i-1] * num[i])
    // dp[i] = max(dp[i-1], maxDP[i])
    public int maxProduct1(int[] nums) {

        int ans = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = imax;
            imax = Math.max(Math.max(imax * nums[i], nums[i]), imin * nums[i]);
            imin = Math.min(Math.min(imin * nums[i], nums[i]), temp * nums[i]);

            ans = Math.max(ans, imax);
        }
        return ans;
    }
}
