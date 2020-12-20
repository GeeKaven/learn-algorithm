package moe.tawawa.leetcode.q05_Longest_Palindromic_Substring;

/**
 * @author GeeKaven
 * @date 2020/12/20 16:35
 *
 * keys: 动态规划, 中心扩散
 */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] sArr = s.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (sArr[i] == sArr[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return  s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩散法： 以每一个位置的奇数位，偶数位分别向左，向右找到最长的回文数
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] sArr = s.toCharArray();

        for (int i = 0; i < len; i++) {
            int oddLen = expendPalindromeLen(sArr, i, i);
            int evenLen = expendPalindromeLen(sArr, i, i+1);

            int currLen = Math.max(oddLen, evenLen);
            if (currLen > maxLen) {
                maxLen = currLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private int expendPalindromeLen(char[] sArr, int left, int right) {
        int len = sArr.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (sArr[i] == sArr[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("ab"));
        System.out.println(solution.longestPalindrome1("abba"));
    }
}
