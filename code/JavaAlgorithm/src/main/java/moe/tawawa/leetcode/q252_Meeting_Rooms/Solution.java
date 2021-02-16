package moe.tawawa.leetcode.q252_Meeting_Rooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author GeeKaven
 * @date 2021/2/16 20:37
 */
public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }
}
