package moe.tawawa.leetcode.q56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2021/2/12 22:30
 */
public class Solution {
    // 1. 先按左从小到大排序
    // 2. 设置可添加区间为第一个
    // 3. 从第二个开始遍历, 可添加区间右 >= 当前区间左，表示有重叠，则合并, 修改可添加区间右
    //    否则就插入可插入区间, 然后修改可插入区间为当前区间，然后重复
    // 4. 结束后，将目前可插入区间插入答案
    // 5. 生产二维数组，返回
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 0) {
            return intervals;
        }

        List<int []> path = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] nowInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (nowInterval[1] >= intervals[i][0]) {
                nowInterval[1] = Math.max(nowInterval[1], intervals[i][1]);
            } else {
                path.add(nowInterval);
                nowInterval = intervals[i];
            }
        }
        path.add(nowInterval);
        int[][] ans = new int[path.size()][2];
        for (int i = 0; i < path.size(); i++) {
            ans[i] = path.get(i);
        }
        return ans;
    }
}
