package moe.tawawa.leetcode.q86_Partition_List;

import model.ListNode;

/**
 * @author GeeKaven
 * @date 2021/1/3 20:08
 */
public class Solution {
    // 本质模拟
    // 遍历原链表，分别接入大链表和小链表
    // 然后将小，大相连
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}
