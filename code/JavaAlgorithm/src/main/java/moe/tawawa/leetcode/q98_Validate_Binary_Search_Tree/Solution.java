package moe.tawawa.leetcode.q98_Validate_Binary_Search_Tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2021/1/22 22:53
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return false;
        }

        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);

        int max = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            } else {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }

    TreeNode pre = null;
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST1(root.left)) {
            return false;
        }
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        return isValidBST1(root.right);
    }
}
