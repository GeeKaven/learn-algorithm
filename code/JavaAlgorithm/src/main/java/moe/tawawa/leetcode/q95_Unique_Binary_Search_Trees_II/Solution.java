package moe.tawawa.leetcode.q95_Unique_Binary_Search_Trees_II;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2020/12/26 21:33
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generate(1, n);
    }

    // [1, i - 1] + i + [i+1, n]
    // [] => null（空节点） //递归终点
    // [i] => i (单个节点） //递归终点
    private List<TreeNode> generate(int begin, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (begin > end) {
            ans.add(null);
            return ans;
        }
        if (begin == end) {
            TreeNode node = new TreeNode(begin);
            ans.add(node);
            return ans;
        }

        for (int i = begin; i <= end ; i++) {
            List<TreeNode> leftTreeNode = generate(begin, i - 1);
            List<TreeNode> rightTreeNode = generate(i + 1, end);
            for (TreeNode leftNode : leftTreeNode) {
                for (TreeNode rightNode : rightTreeNode) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    ans.add(node);
                }
            }
        }

        return ans;
    }
}
