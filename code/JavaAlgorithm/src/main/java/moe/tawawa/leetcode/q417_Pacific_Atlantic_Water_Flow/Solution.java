package moe.tawawa.leetcode.q417_Pacific_Atlantic_Water_Flow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2021/3/10 22:57
 */
public class Solution {

    // 二维平面回溯问题
    // 逆向思维，从太平洋或大西洋开始能到达的地方
    // 两者的交点就是都能到达的地方
    int m, n;
    int[][] directs = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();

        if (matrix.length == 0) {
            return ans;
        }

        m = matrix.length;
        n = matrix[0].length;
        int[][] ao = new int[m][n]; // 太平洋
        int[][] po = new int[m][n]; // 大西洋

        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, ao);
            dfs(matrix, i, n - 1, po);
        }

        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, ao);
            dfs(matrix, m - 1, i, po);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ao[i][j] == 1 && po[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] matrix, int x, int y, int[][] tmp) {
        tmp[x][y] = 1;
        for (int[] d : directs) {
            int newX = x + d[0];
            int newY = y + d[1];

            if (inArea(newX, newY) && matrix[newX][newY] >= matrix[x][y] && tmp[newX][newY] != 1) {
                dfs(matrix, newX, newY, tmp);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >=0 && y < n;
    }
}
