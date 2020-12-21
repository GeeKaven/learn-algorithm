package moe.tawawa.leetcode.q09_Palindrome_Number;

/**
 * @author GeeKaven
 * @date 2020/12/21 14:13
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int[] num = new int[32];
        int index = 0;
        while (x > 0) {
            num[index] = x % 10;
            x = x / 10;
            index++;
        }
        boolean isPalindrome = true;
        for (int left = 0, right = index - 1; left <= right; left++, right--) {
            if (num[left] != num[right]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    // 反转一半数字，结束条件 剩余数 <= 反转数
    public boolean isPalindrome1(int x) {
        // 负数，大于0且最后一位是0的正数，不可能是
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x = x / 10;
        }

        return x == reverseNum / 10 || x == reverseNum;
    }

    //先找到最高位
    //然后利用x%10 == x/help来判断第一位和最后一位是否相等
    //之后去除第一位  x % help 和 最后一位 / 10, help减一位，继续判断
    //没有不相等就是回文数
    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int help = 1;
        int tmp = x;
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x != 0) {
            if (x % 10 != x / help) {
                return false;
            }
            x = x % help / 10;
            help /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(1213));
        System.out.println(solution.isPalindrome1(121));

    }
}
