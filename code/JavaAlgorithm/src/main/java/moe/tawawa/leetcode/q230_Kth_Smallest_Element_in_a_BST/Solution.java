package moe.tawawa.leetcode.q230_Kth_Smallest_Element_in_a_BST;

import model.TreeNode;

import java.util.Stack;

/**
 * @author GeeKaven
 * @date 2021/1/25 20:01
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tree = root;
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                k--;
                if (k == 0) {
                    return tree.val;
                }
                tree = tree.right;
            }
        }
        return 0;
    }

    int count, res;
    public int kthSmallest1(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
