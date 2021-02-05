package moe.tawawa.leetcode.q141_Linked_List_Cycle;

import model.ListNode;

/**
 * @author GeeKaven
 * @date 2021/2/5 21:49
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null) {
            p2 = p2.next;
            if(p2 != null) {
                p2 = p2.next;
            };
            if (p1 == p2) {
                return true;
            }
            if(p1 != null) {
                p1 = p1.next;
            }
        }

        return false;
    }
}
