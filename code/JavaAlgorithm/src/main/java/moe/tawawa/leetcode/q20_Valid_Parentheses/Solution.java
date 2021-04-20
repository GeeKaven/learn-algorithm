package moe.tawawa.leetcode.q20_Valid_Parentheses;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author GeeKaven
 * @date 2021/4/20 22:19
 */
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}') || (stack.peek() == '[' && c == ']'))) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
