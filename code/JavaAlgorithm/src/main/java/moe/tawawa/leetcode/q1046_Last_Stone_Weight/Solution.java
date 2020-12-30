package moe.tawawa.leetcode.q1046_Last_Stone_Weight;

import java.util.PriorityQueue;

/**
 * @author GeeKaven
 * @date 2020/12/30 22:13
 */
public class Solution {
    // 最大
    public int lastStoneWeight(int[] stones) {
        if (stones.length <= 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        int len = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(len, ((o1, o2) -> o2 - o1));
        for (int i = 0; i < len; i++) {
            pq.offer(stones[i]);
        }
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (y > x) {
                pq.offer(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(new int[]{2,2}));
    }
}
