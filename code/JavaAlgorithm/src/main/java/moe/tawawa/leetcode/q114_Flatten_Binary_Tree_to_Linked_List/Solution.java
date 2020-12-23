package moe.tawawa.leetcode.q114_Flatten_Binary_Tree_to_Linked_List;

import model.TreeNode;
import utils.Utils;

import java.util.Stack;

/**
 * @author GeeKaven
 * @date 2020/12/23 17:01
 */
public class Solution {

    private TreeNode pre;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public void flatten1(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            if(pre!=null){
                pre.right = temp;
                pre.left = null;
            }
            // 使用栈保存右节点
            if (temp.right != null){
                s.push(temp.right);
            }
            if (temp.left != null){
                s.push(temp.left);
            }
            pre = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = Utils.createTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        Solution solution = new Solution();
        solution.flatten(tree);
        System.out.println("");
    }
}
