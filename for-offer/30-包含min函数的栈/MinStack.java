import java.util.Stack;

public class MinStack {

  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  /** initialize your data structure here. */
  public MinStack() {
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
    return stack.isEmpty() ? null : stack.peek();
  }
  
  public int min() {
    return minStack.isEmpty() ? null : minStack.peek();
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.min());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.min());
  }
}