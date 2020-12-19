package moe.tawawa.foroffer;

import model.ListNode;

import java.util.Stack;

/**
 * @author geekaven
 * @date 2020/6/10 11:51 AM
 */
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
}
