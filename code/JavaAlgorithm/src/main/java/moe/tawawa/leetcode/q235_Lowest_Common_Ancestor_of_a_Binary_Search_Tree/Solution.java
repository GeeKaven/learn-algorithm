package moe.tawawa.leetcode.q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import model.TreeNode;

/**
 * @author GeeKaven
 * @date 2021/1/25 20:30
 */
public class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }

    public void helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }
        if ((p.val <= root.val && q.val >= root.val)
                || (p.val >= root.val && q.val <= root.val)) {
            ans = root;
            return;
        }
        helper(root.left, p, q);
        helper(root.right, p, q);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //如果小于等于0，说明p和q位于root的两侧，直接返回即可
        if ((root.val - p.val) * (root.val - q.val) <= 0)
            return root;
        //否则，p和q位于root的同一侧，就继续往下找
        return lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
    }
}
