package moe.tawawa.leetcode.q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import model.TreeNode;

/**
 * @author GeeKaven
 * @date 2020/12/22 19:33
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preBegin]);
        int numSize = 0;
        int index = inBegin;
        while (inorder[index] != preorder[preBegin]) {
            index++;
            numSize++;
        }

        root.left = buildTree(preorder, inorder, preBegin + 1, preBegin + numSize, inBegin, index - 1);
        root.right = buildTree(preorder, inorder, preBegin + numSize + 1, preEnd, index + 1, inEnd);

        return root;
    }

    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        // 中序遍历的结束节点
        // 在中序遍历中，左子树一定在根节点之前
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println("");
    }
}
