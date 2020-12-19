package moe.tawawa.foroffer;

import java.util.Stack;

/**
 * @author geekaven
 * @date 2020/6/10 12:02 PM
 */
public class Lcof30 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public Lcof30() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek() < x ? minStack.peek() : x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.isEmpty() ? Integer.parseInt(null) : stack.peek();
    }

    public int min() {
        return minStack.isEmpty() ? Integer.parseInt(null) : minStack.peek();
    }
}
