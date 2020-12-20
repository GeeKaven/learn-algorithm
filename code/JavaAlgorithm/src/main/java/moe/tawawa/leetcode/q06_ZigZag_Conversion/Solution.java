package moe.tawawa.leetcode.q06_ZigZag_Conversion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2020/12/20 23:04
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i >= numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        rows.forEach(sb -> res.append(sb.toString()));
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert( "LEETCODEISHIRING", 3));
    }
}
