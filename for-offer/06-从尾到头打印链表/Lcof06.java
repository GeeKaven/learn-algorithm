import java.util.Stack;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

public class Lcof06 {
  public int[] reversePrint(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    while (head != null) {
      stack.push(head.val);
      head = head.next;
    }
    int stackSize = stack.size();
    int[] res = new int[stackSize];
    for (int i = 0; i < stackSize; i++) {
      res[i] = stack.pop();
    }
    return res;
  }

  public void test() {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(3);
    ListNode l3 = new ListNode(2);
    l1.next = l2;
    l2.next = l3;
    reversePrint(l1);
    reversePrint(null);
  }


  public static void main(String[] args) {
    Lcof06 lcof06 = new Lcof06();
    lcof06.test();
  }
}