class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class Lcof22 {
  public ListNode getKthFromEnd(ListNode head, int k) {

    if (head == null || k <= 0) {
      return null;
    }

    ListNode fast = head;
    ListNode slow = head;

    for (int i = 0; i < k - 1; i++) {
      fast = fast.next;
      if (fast == null) {
        return null;
      }
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    Lcof22 lcof22  = new Lcof22();
    ListNode l1 = lcof22.getKthFromEnd(n1, 2);
    ListNode l2 = lcof22.getKthFromEnd(n1, 0);
    ListNode l3 = lcof22.getKthFromEnd(n1, 6);
    System.out.println();
  }
}