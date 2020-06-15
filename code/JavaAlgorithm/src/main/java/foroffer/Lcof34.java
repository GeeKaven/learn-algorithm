package foroffer;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lcof34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> allPath = new ArrayList<>();
        findPath(root, path, allPath, sum, 0);
        return allPath;
    }

    public void findPath(TreeNode root, List<Integer> currPath, List<List<Integer>> allPath, int targetSum, int currentSum) {

        currPath.add(root.val);
        currentSum = currentSum + root.val;
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == targetSum && isLeaf) {
            allPath.add(new ArrayList<>(currPath));
        }

        if (root.left != null) {
            findPath(root.left, currPath, allPath, targetSum, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, currPath, allPath, targetSum, currentSum);
        }

        currentSum = currentSum - root.val;
        currPath.remove(currPath.size() - 1);
    }
}
