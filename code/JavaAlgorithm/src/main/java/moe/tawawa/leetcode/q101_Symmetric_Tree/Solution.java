package moe.tawawa.leetcode.q101_Symmetric_Tree;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author GeeKaven
 * @date 2020/12/23 18:15
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        // 左节点的左子树和右节点的右子树
        // 左节点的右子树和右节点的左子树
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    // 非递归
    // 使用队列, 两两比较
    // 太慢了
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean ans = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null) {
                continue;
            }
            if ((n1 == null || n2 == null) || n1.val != n2.val) {
                ans = false;
                break;
            }
            queue.offer(n1.left);
            queue.offer(n2.right);

            queue.offer(n1.right);
            queue.offer(n2.left);
        }
        return ans;
    }
}
