public class Lcof25 {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

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

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(3);
    ListNode n3 = new ListNode(5);
    ListNode n4 = new ListNode(7);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    
    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(6);
    ListNode l4 = new ListNode(8);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    
    Lcof25 lcof25 = new Lcof25();
    ListNode mergeNode = lcof25.mergeTwoLists(n1, l1);
    System.out.println();
  }
}