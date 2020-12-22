package utils;

import model.ListNode;
import model.TreeNode;

import java.util.List;

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

    public static TreeNode buildBinaryTree(Integer[] nums) {
        return createTreeByArray(nums, 0);
    }

    private static TreeNode createTreeByArray(Integer[] array, int index) {
        TreeNode node = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            node = new TreeNode(value);
            node.left = createTreeByArray(array, index * 2 + 1);
            node.right = createTreeByArray(array, index * 2 + 2);
            return node;
        }
        return node;
    }

    public static void printListNode(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println("");
    }

    public static void printDoubleList(List<List<Integer>> lists) {
        lists.forEach(list -> {
            list.forEach(item -> {
                System.out.print(item + " ");
            });
            System.out.println("");
        });
    }
}
