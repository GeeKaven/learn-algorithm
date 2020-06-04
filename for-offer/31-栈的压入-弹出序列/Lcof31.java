import java.util.Stack;

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

  public static void main(String[] args) {
    int[] pushed = new int[] {1,2,3,4,5};
    int[] popped = new int[] {4,3,5,1,2};

    Lcof31 lcof31 = new Lcof31();
    System.out.println(lcof31.validateStackSequences(pushed, popped));
  }
}