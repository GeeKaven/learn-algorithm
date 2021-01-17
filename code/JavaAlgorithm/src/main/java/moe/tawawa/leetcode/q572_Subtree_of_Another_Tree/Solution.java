package moe.tawawa.leetcode.q572_Subtree_of_Another_Tree;

import model.TreeNode;

/**
 * @author GeeKaven
 * @date 2021/1/17 22:55
 */
public class Solution {
    // 树的子树
    // 与判断两棵树是否相同类似
    // 就是判断树的左子树与目标，右子树与目标， 当前节点与目标是否相同
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
