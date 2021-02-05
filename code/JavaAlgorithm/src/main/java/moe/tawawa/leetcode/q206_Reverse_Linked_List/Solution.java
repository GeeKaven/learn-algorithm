package moe.tawawa.leetcode.q206_Reverse_Linked_List;

import model.ListNode;

/**
 * @author GeeKaven
 * @date 2021/2/5 21:39
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode now = head;
        while (now != null) {
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
