package moe.tawawa.leetcode.q199_Binary_Tree_Right_Side_View;

import model.TreeNode;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GeeKaven
 * @date 2020/12/23 17:54
 */
public class Solution {
    // 二叉树的右视图
    // 层序遍历的变种, 这次用dfs解
    // 先右在左
    //
    // bfs的话就是将每一层的最后一个加入数组
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root, 1);
        return ans;
    }

    public void dfs(List<Integer> ans, TreeNode node, Integer level) {
        if (node == null) {
            return;
        }
        if (ans.size() + 1 == level) {
            ans.add(node.val);
        }
        dfs(ans, node.right, level + 1);
        dfs(ans, node.left, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = Utils.createTree(new Integer[]{1,2,3,null,5,null,4});
        Solution solution = new Solution();
        Utils.printList(solution.rightSideView(root));
    }
}
