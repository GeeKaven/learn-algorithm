package foroffer;

import model.ListNode;

/**
 * @author geekaven
 * @date 2020/6/10 11:58 AM
 */
public class Lcof18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode preNode = null;
        ListNode targetNode = head;
        while (targetNode != null) {
            if (val == targetNode.val) {
                break;
            }
            preNode = targetNode;
            targetNode = targetNode.next;
        }
        if (targetNode == head) {
            preNode = targetNode.next;
            head = preNode;
        } else {
            preNode.next = targetNode.next;
        }

        return head;
    }
}
