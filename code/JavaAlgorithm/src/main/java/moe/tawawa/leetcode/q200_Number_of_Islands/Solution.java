package moe.tawawa.leetcode.q200_Number_of_Islands;

/**
 * @author GeeKaven
 * @date 2021/3/10 23:31
 */
public class Solution {
    // 思路深度优先遍历
    // 针对陆地1，进行上，下，左，右遍历，当一次遍历完成后，就是一块陆地
    // dfs两个条件，bad case 和 领接遍历方向
    public int numIslands(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y, char[][] grid) {
        if (!inArea(x, y, grid)) {
            return;
        }

        if (grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '2';

        dfs(x + 1, y, grid);
        dfs(x - 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x, y - 1, grid);
    }

    public boolean inArea(int x, int y, char[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
