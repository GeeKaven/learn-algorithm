package moe.tawawa.leetcode.q21_Merge_Two_Sorted_Lists;

import model.ListNode;

/**
 * @author GeeKaven
 * @date 2021/2/5 22:27
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode head = l1.val <= l2.val ? l1 : l2;

        ListNode pre1 = null;
        ListNode pre2 = null;
        while(l1 != null && l2 != null) {
            while (l1 != null && l2 != null && l1.val <= l2.val) {
                pre1 = l1;
                l1 = l1.next;
            }
            if (pre1 != null) {
                pre1.next = l2;
                pre1 = null;
            }
            while (l1 != null && l2 != null && l2.val <= l1.val) {
                pre2 = l2;
                l2 = l2.next;
            }
            if (pre2 != null) {
                pre2.next = l1;
                pre2 = null;
            }

        }
        return head;
    }


}
