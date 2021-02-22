package moe.tawawa.leetcode.q73_Set_Matrix_Zeroes;

import java.util.HashSet;
import java.util.Set;

/**
 * @author GeeKaven
 * @date 2021/2/22 21:49
 */
public class Solution {

    // 暴力解法
    // 先找到所有0所在的行，列
    // 然后重新遍历，属于0所在的行，列都改为0
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    row.add(r);
                    col.add(c);
                }
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (row.contains(r) || col.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
    }

    // 用第一行，第一列做0标志位，但是也有可能有0，所有要预先标记
    // 1. 记录第一行，第一列是否有0
    // 2. 从第二行，第二列开始遍历，如果遇到0，则将该位子所在的第一行，第一列置为0
    // 3. 重新从第二行，第二列遍历，如果遇到改位子所在的第一行或第一列为0，则将该位置置为0
    // 4. 如果第一行或第一列有0，则将第一列或第一行置为0
    public void setZeroes1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0Flag = false;
        boolean col0Flag = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0Flag = true;
                break;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                row0Flag = true;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0Flag) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col0Flag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
