package moe.tawawa.leetcode.q094_Binary_Tree_Inorder_Traversal;

import model.TreeNode;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author GeeKaven
 * @date 2020/12/22 17:41
 */
public class Solution {

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traversal(ans, root);
        return ans;
    }
    private void traversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(list, root.left);
        list.add(root.val);
        traversal(list, root.right);
    }

    // 非递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tree = root;
        while (tree != null || !stack.empty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.empty()) {
                tree = stack.pop();
                ans.add(tree.val);
                tree = tree.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode tree = Utils.createTree(new Integer[] {1, null, 2, 3});
        Solution solution = new Solution();
        Utils.printList(solution.inorderTraversal(tree));
    }
}
