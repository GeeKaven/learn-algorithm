package moe.tawawa.leetcode.q19_Remove_Nth_Node_From_End_of_List;

import model.ListNode;

/**
 * @author GeeKaven
 * @date 2021/2/5 22:44
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = slow.next;
            slow = null;
            return head;
        }
        while(fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(pre != null) {
            pre.next = slow.next;
            slow = null;
        }
        return head;
    }
}
