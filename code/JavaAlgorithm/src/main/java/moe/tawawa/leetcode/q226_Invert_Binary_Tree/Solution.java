package moe.tawawa.leetcode.q226_Invert_Binary_Tree;

import model.TreeNode;
import utils.Utils;

/**
 * @author GeeKaven
 * @date 2020/12/22 18:53
 */
public class Solution {
    // 先交换在递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // 先递归到底，在交换
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode invertLeft = invertTree1(root.left);
        TreeNode invertRight = invertTree1(root.right);
        root.left = invertRight;
        root.right = invertLeft;
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = Utils.createTree(new Integer[] {4,2,7,1,3,6,9});
        Solution solution = new Solution();
        TreeNode t = solution.invertTree(tree);
        System.out.print(1);
    }
}
