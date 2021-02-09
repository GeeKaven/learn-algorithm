package moe.tawawa.leetcode.q143_Reorder_List;

import model.ListNode;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2021/2/9 20:24
 */
public class Solution {

    public void reorderList(ListNode head) {

        if(head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;

        // 反转后面的列表
        ListNode h = slow;
        pre = null;
        while (h != null) {
            ListNode next = h.next;
            h.next = pre;
            pre = h;
            h = next;
        }

        // 合并
        ListNode rHead = pre;
        ListNode sHead = head;
        while (sHead != null && rHead != null) {
            ListNode sNext = sHead.next;
            sHead.next = rHead;
            ListNode rNext = rHead.next;
            rHead.next = sNext;
            sHead = sNext;
            rHead = rNext;
        }
    }

    public void reorderList1(ListNode head) {

        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode node = head.next;
        while(node != null) {
            list.add(node);
            node = node.next;
        }

        int start = 0;
        int end = list.size() - 1;
        ListNode p = head;
        while(start <= end) {
            ListNode endNode = list.get(end);
            ListNode startNode = list.get(start);
            p.next = endNode;
            if (start < end) {
                endNode.next = startNode;
            }
            if(start == end) {
                endNode.next = null;
            } else if(start == end - 1) {
                startNode.next = null;
            }
            p = startNode;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ListNode head = Utils.buildList(new int[]{1,2,3,4,5,6});
        Solution s = new Solution();
        s.reorderList(head);
        Utils.printListNode(head);
    }
}
