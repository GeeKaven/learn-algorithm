package moe.tawawa.leetcode.q011_Container_With_Most_Water;

/**
 * @author GeeKaven
 * @date 2020/12/21 14:36
 */
public class Solution {
    /**
     * keys: 双指针， 最左，最右两条边， 舍弃较小的边
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            max = Math.max(h * w, max);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 2, 1}));
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
