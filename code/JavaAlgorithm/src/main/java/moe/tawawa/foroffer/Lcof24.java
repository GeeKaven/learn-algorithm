package moe.tawawa.foroffer;

import model.ListNode;

/**
 * @author geekaven
 * @date 2020/6/10 12:00 PM
 */
public class Lcof24 {
    public ListNode reverseList(ListNode head) {

        ListNode fast = head;
        ListNode slow = null;
        ListNode temp = null;

        while (fast != null) {
            temp = fast;
            fast = fast.next;
            temp.next = slow;
            slow = temp;
        }

        return slow;
    }
}
