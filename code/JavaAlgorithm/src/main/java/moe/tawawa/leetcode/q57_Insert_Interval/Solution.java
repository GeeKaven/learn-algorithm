package moe.tawawa.leetcode.q57_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2021/2/12 22:26
 */
public class Solution {
    // 1. 找到插入区间的左边：  当前区间的右 < 插入区间的左
    // 2. 找到重叠区间: 当前区间的左 <= 插入区间的右, 有重叠，合并, 左取最小，右取最大
    // 3. 剩下的都在插入区间的右边: 当前区间左 > 插入区间右
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> res = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        while(i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        int[][] ans = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            ans[j] = res.get(j);
        }
        return ans;
    }
}
