package foroffer;

import model.ListNode;

/**
 * @author geekaven
 * @date 2020/6/10 12:00 PM
 */
public class Lcof25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergeNode = null;
        if (l1.val < l2.val) {
            mergeNode = l1;
            mergeNode.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeNode = l2;
            mergeNode.next = mergeTwoLists(l1, l2.next);
        }

        return mergeNode;
    }
}
