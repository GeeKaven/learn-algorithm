package moe.tawawa.leetcode.q108_Convert_Sorted_Array_to_Binary_Search_Tree;

import model.TreeNode;

/**
 * @author GeeKaven
 * @date 2020/12/26 22:06
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int i = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[i]);
        node.left = build(nums, start, i - 1);
        node.right = build(nums, i + 1, end);

        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = solution.sortedArrayToBST(new int[]{0,1,2,3,4,5});
        System.out.print("");
    }
}
