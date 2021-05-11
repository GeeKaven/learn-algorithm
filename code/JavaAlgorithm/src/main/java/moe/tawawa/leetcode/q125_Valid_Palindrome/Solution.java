package moe.tawawa.leetcode.q125_Valid_Palindrome;

/**
 * @author GeeKaven
 * @date 2021/5/11 23:13
 */
public class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int length = arr.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (Character.isLetterOrDigit(arr[i])) {
                sb.append(Character.toLowerCase(arr[i]));
            }
        }

        StringBuffer rev = new StringBuffer(sb).reverse();
        return sb.toString().equals(rev.toString());
    }
}
