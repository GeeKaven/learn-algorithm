class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class Lcof24 {

  public ListNode reverseList(ListNode head) {
    
    ListNode fast = head;
    ListNode slow = null;
    ListNode temp = null;

    while (fast != null) {
      temp = fast;
      fast = fast.next;
      temp.next = slow;
      slow = temp;
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
    Lcof23 lcof23  = new Lcof23();
    ListNode rN = lcof23.reverseList(n1);
    System.out.println();
  }  
}