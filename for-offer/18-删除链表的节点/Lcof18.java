class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

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

  public static void main(String[] args) {
    ListNode h = new ListNode(4);
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(5);
    h.next = n1;
    n1.next = n2;

    Lcof18 lcof18 = new Lcof18();
    lcof18.deleteNode(h, 5);
    System.out.println();
  }
}