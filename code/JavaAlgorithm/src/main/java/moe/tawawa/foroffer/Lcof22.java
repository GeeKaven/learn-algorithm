package moe.tawawa.foroffer;

import model.ListNode;

/**
 * @author geekaven
 * @date 2020/6/10 12:00 PM
 */
public class Lcof22 {
    public ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
