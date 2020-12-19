package moe.tawawa.foroffer;

import java.util.Stack;

/**
 * @author geekaven
 * @date 2020/6/10 12:04 PM
 */
public class Lcof31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length == 0) {
            return true;
        }
        boolean isSequences = false;
        int length = pushed.length;
        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (popIndex - pushIndex < length) {
            while (stack.isEmpty() || stack.peek() != popped[popIndex]) {

                if (pushIndex == length) {
                    break;
                }

                stack.push(pushed[pushIndex]);
                pushIndex++;
            }

            if (stack.isEmpty() || stack.peek() != popped[popIndex]) {
                break;
            }

            stack.pop();
            popIndex++;
        }

        if (stack.isEmpty() && popIndex == length) {
            isSequences = true;
        }

        return isSequences;
    }
}
