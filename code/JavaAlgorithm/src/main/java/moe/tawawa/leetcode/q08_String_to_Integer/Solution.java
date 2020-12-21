package moe.tawawa.leetcode.q08_String_to_Integer;

/**
 * @author GeeKaven
 * @date 2020/12/21 13:19
 */
public class Solution {
    public int myAtoi(String s) {
        int index = 0;
        char[] sArr = s.toCharArray();
        int len = sArr.length;
        // 去除前空格
        while (index < len && sArr[index] == ' ') {
            index++;
        }

        //全是空格的情况
        if (index == len) {
            return 0;
        }

        //是否有+，-号
        int postive = 1;
        if (sArr[index] == '-') {
            postive = -1;
            index++;
        } else if (sArr[index] == '+') {
            index++;
        }

        // 开始遍历， 同时判断 (*10+digit) 后是否会越界
        int total = 0;
        while (index < len) {
            int digit = sArr[index] - '0';
            // 不是数字直接退出
            if (digit < 0 || digit > 9) {
                break;
            }

            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && digit > Integer.MAX_VALUE % 10)) {
                return postive == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            //计算
            total = total * 10 + digit;
            index++;
        }

        // 根据正负返回
        return total * postive;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("-1234 wiaokj"));
    }
}
