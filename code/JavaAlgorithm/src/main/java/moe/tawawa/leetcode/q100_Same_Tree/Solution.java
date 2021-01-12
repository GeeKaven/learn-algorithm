package moe.tawawa.leetcode.q100_Same_Tree;

import model.TreeNode;

/**
 * @author GeeKaven
 * @date 2021/1/12 16:28
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
