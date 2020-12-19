package moe.tawawa.leetcode.q02_Add_Two_Numbers;

import model.ListNode;
import utils.Utils;

/**
 * @author GeeKaven
 * @date 2020/12/19 16:45
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pL1 = l1;
        ListNode pL2 = l2;
        boolean carry = false;

        ListNode root = null;
        ListNode ptr = null;
        while (pL1 != null || pL2 != null || carry) {
            int value = 0;
            if (pL1 != null) {
                value += pL1.val;
                pL1 = pL1.next;
            }
            if (pL2 != null) {
                value += pL2.val;
                pL2 = pL2.next;
            }
            if (carry) {
                value += 1;
            }
            ListNode temp = new ListNode();
            if (value >= 10) {
                carry = true;
                temp.val = value - 10;
            } else {
                carry = false;
                temp.val = value;
            }
            if (root == null) {
                root = temp;
                ptr = root;
            } else {
                ptr.next = temp;
                ptr = temp;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode n1 = Utils.buildList(new int[]{2, 4, 3});
        ListNode n2 = Utils.buildList(new int[]{5, 6, 9, 9, 9, 9});
        Utils.printListNode(n1);
        Utils.printListNode(n2);
        Solution s = new Solution();
        Utils.printListNode(s.addTwoNumbers(n1, n2));
    }
}
