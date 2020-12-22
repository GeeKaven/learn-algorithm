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

    // 非递归， 颜色标记法：核心记录节点访问状态，如果访问了就弹出
    // 每个节点入栈两次
    // 好处：统一非递归前，中，后遍历二叉树代码，方便记忆

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object obj = stack.pop();
            if (obj instanceof TreeNode) {
                TreeNode node = (TreeNode)obj;
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                ans.add((int) obj);
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
