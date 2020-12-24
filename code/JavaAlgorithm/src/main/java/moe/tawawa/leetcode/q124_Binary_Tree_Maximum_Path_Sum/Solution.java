package moe.tawawa.leetcode.q124_Binary_Tree_Maximum_Path_Sum;

import model.TreeNode;

/**
 * @author GeeKaven
 * @date 2020/12/24 20:30
 */
public class Solution {

    /**
     * keys： 深度优先
     * 针对单个节点，得到左子树的最大值，右子树的最大值
     * 以该节点可能最大路径就是，当前val + 左子树最大 + 右子树最大
     * 然后与当前max比较
     * 最后给父节点返回以其节点为路径的最大值
     */
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        int lnr = root.val + left + right;
        max = Math.max(max, lnr);

        return root.val + Math.max(left, right);
    }
}
