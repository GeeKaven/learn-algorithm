package foroffer;

import java.util.Stack;

/**
 * @author geekaven
 * @date 2020/6/10 11:53 AM
 */
public class Lcof09 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Lcof09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}
