package model;

/**
 * @author laiang
 * @date 2020/6/10 11:39 AM
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}

    public ListNode(int x) {
        val = x;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
