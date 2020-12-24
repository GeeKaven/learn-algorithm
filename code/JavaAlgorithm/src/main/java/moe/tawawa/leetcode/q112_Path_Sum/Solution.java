package moe.tawawa.leetcode.q112_Path_Sum;

import model.TreeNode;
import utils.Utils;

/**
 * @author GeeKaven
 * @date 2020/12/24 20:59
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode root, int currSum, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return currSum + root.val == target;
        }
        return dfs(root.left, currSum + root.val, target)
                || dfs(root.right, currSum + root.val, target);
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        // 当前节点的子节点到叶子节点的路径和是否等于 sum - 当前节点值
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode tree = Utils.createTree(new Integer[]{1, 2});
        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(tree, 2));
    }
}