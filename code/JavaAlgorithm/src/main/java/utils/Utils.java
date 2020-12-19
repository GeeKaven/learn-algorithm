package utils;

import model.ListNode;

/**
 * @author GeeKaven
 * @date 2020/12/19 17:25
 */
public class Utils {
    public static ListNode buildList(int[] nums) {
        ListNode root = null;
        ListNode ptr = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
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

    public static void printListNode(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println("");
    }
}
