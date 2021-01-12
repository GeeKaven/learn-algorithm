package moe.tawawa.leetcode.q297_Serialize_and_Deserialize_Binary_Tree;

import model.TreeNode;
import utils.Utils;

import java.util.*;

/**
 * @author GeeKaven
 * @date 2021/1/12 17:04
 */
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        rSerialize(root, sb);
        return sb.toString();
    }

    public void rSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("None,");
        } else {
            sb.append(root.val);
            sb.append(",");
            rSerialize(root.left, sb);
            rSerialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> node = new LinkedList<>(Arrays.asList(data.split(",").clone()));

        return rDeserialize(node);
    }

    public TreeNode rDeserialize(List<String> l) {
        if (l.get(0).equals("None")) {
            l.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        node.left = rDeserialize(l);
        node.right = rDeserialize(l);
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t = Utils.createTree(new Integer[] {1,2,3,null,null,4,5,6,7});
        String s = solution.serialize(t);
        System.out.println(s);
        TreeNode n = solution.deserialize(s);
        System.out.println();
    }
}