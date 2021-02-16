package moe.tawawa.leetcode.q253_Meeting_Rooms_II;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author GeeKaven
 * @date 2021/2/16 20:53
 */
public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int meetRoom = 0;
        for (int i = 0; i < intervals.length; i++) {
            while (!heap.isEmpty() && intervals[i][0] >= heap.peek()) {
                heap.poll();
            }
            heap.offer(intervals[i][1]);
            meetRoom = Math.max(meetRoom, heap.size());
        }

        return meetRoom;
    }

    // 上下车问题
    // 开始结束时间排序
    // 开始+1，结束-1
    // 这个期间最大的就是至少需要的会议室数
    public int minMeetingRooms1(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int p1 = 0;
        int p2 = 0;
        int count = 0;
        int room = 0;
        while (p1 < start.length) {
            if (start[p1] < end[p2]) {
                count++;
                p1++;
                room = Math.max(count, room);
            } else if (start[p1] > end[p2]) {
                count--;
                p2++;
            } else {
                p1++;
                p2++;
            }
        }
        return room;
    }
}
