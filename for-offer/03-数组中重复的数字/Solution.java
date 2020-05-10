import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字。
 * 
 * 
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 
 * 示例 1：
 * 
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3 
 * 
 * 
 * 限制：
 * 
 * 2 <= n <= 100000
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 */
public class Solution {

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

  public void test() {
    int[] test = new int[]{2, 3, 1, 0, 2, 5, 3};
    int res = findRepeatNumber(test);
    assert res == 2;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.test();
    System.out.println("All Pass");
  }
}