package moe.tawawa.leetcode.q104_Maximum_Depth_of_Binary_Tree;

import model.TreeNode;
import utils.Utils;

/**
 * @author GeeKaven
 * @date 2020/12/22 19:20
 */
public class Solution {

    // 递归
    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }

    private int depth(TreeNode tree, int dep) {
        if (tree == null) {
            return dep;
        }
        int leftDepth = depth(tree.left, dep + 1);
        int rightDepth = depth(tree.right, dep + 1);
        return Math.max(leftDepth, rightDepth);
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth1(root.left);
            int rightDepth = maxDepth1(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    //非递归，就是层序遍历

    public static void main(String[] args) {
        TreeNode tree = Utils.createTree(new Integer[] {4,2,7,1,3,6,9});
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(tree));
    }
}
