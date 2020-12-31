package moe.tawawa.leetcode.q435_Non_overlapping_Intervals;

import java.util.Arrays;

/**
 * @author GeeKaven
 * @date 2020/12/31 15:44
 */
public class Solution {
    // 贪心算法
    // 不断寻找结束最早的区间
    // 最早结束时间就是最早区间的结束时间
    // 后面的区间如果与最早区间不想交，则最早结束时间更新为次区间结束时间（也就是次题不想交区间个数+1）
    // 最后的到的就是最多的不相交区间
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1,2}, {2, 3}, {2, 4}, {3, 4}, {1, 100}}));
    }
}
