package moe.tawawa.leetcode.q103_Binary_Tree_Zigzag_Level_Order_Traversal;

import model.TreeNode;
import utils.Utils;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author GeeKaven
 * @date 2020/12/22 16:23
 */
public class Solution {
    /**
     * keys: BFS，广度优先遍历二叉树， 在记录每一层数字时，根据标记插入开头或者插入结尾
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = false;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode item = queue.poll();

                // 不同于一半广度优先遍历，从开头插入，或者从结尾插入
                if (leftToRight) {
                    level.add(0, item.val);
                } else {
                    level.add(item.val);
                }

                if (item.left != null) {
                    queue.offer(item.left);
                }
                if (item.right != null) {
                    queue.offer(item.right);
                }
            }
            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Solution solution = new Solution();
        Utils.printDoubleList(solution.zigzagLevelOrder(root));
    }
}
