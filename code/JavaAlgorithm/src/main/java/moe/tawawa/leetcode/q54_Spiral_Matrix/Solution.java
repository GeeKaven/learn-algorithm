package moe.tawawa.leetcode.q54_Spiral_Matrix;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2021/2/22 22:41
 */
public class Solution {
    // 模拟右，下，左，上
    // 设置上，左，下，右边界
    // 每次循环边界进行相应的变化
    // 判断是否越界，越界就结束
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        while(true) {

            for(int i = l; i <= r; i++) {
                ans.add(matrix[t][i]);
            }
            t++;
            if (t > b) break;

            for(int i = t; i <= b; i++) {
                ans.add(matrix[i][r]);
            }
            r--;
            if (r < l) break;

            for(int i = r; i >= l; i--) {
                ans.add(matrix[b][i]);
            }
            b--;
            if (b < t) break;

            for(int i = b; i >= t; i--) {
                ans.add(matrix[i][l]);
            }
            l++;
            if (l > r) break;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{2,5,8},{4,0,1}};
        List<Integer> ans = solution.spiralOrder(matrix);
        Utils.printList(ans);
    }
}
