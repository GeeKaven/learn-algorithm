package moe.tawawa.leetcode.q239_Sliding_Window_Maximum;

import utils.Utils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author GeeKaven
 * @date 2021/1/2 20:17
 */
public class Solution {


    // 单调队列
    // 维护一个单调递减的双端队列
    // 如果加入的值比队尾的大，则依次弹出队尾，然后队尾加入该值
    // 队头如果在窗口中，则就是窗口的最大值，否则弹出队头
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.add(i);
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            if (i + 1 >= k) {
                result[i + 1 - k] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        Utils.printArray(result);
    }
}
