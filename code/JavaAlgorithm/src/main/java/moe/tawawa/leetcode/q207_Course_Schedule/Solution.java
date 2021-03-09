package moe.tawawa.leetcode.q207_Course_Schedule;

import java.util.*;

/**
 * @author GeeKaven
 * @date 2021/3/9 22:59
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDeep = new int[numCourses];   //入度表

        Map<Integer, List<Integer>> nMap = new HashMap<>(); // 邻接表

        // 构建入度和邻接表
        for (int[] p : prerequisites) {
            int cur = p[1];
            int next = p[0];
            inDeep[next] = inDeep[next] + 1;

            if (!nMap.containsKey(cur)) {
                nMap.put(cur, new ArrayList<>());
            }
            nMap.get(cur).add(next);
        }

        // 入度为0的入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDeep.length; i++) {
            if (inDeep[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 取出一个节点，学习课程
            Integer selected = queue.poll();

            // 遍历该节点邻接节点，入度-1，如果入度为0则入队
            for (Integer n : nMap.getOrDefault(selected, new ArrayList<>())) {
                inDeep[n] = inDeep[n] - 1;
                if (inDeep[n] == 0) {
                    queue.offer(n);
                }
            }
        }

        for (int i = 0; i < inDeep.length; i++) {
            if (inDeep[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b = s.canFinish(3, new int[][]{{0, 1},{0, 2},{1, 2}});
        System.out.println(b);
    }
}
