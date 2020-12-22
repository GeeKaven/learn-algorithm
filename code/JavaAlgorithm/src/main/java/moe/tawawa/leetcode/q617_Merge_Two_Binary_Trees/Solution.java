package moe.tawawa.leetcode.q617_Merge_Two_Binary_Trees;

import model.TreeNode;

/**
 * @author GeeKaven
 * @date 2020/12/22 20:29
 */
public class Solution {
    // 两个树前序遍历
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return  t1;
        }
        TreeNode merge = new TreeNode(t1.val + t2.val);
        merge.left = mergeTrees(t1.left, t2.left);
        merge.right = mergeTrees(t1.right, t2.right);
        return merge;
    }
}
