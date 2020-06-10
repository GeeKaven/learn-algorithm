package foroffer;

import model.TreeNode;

/**
 * @author geekaven
 * @date 2020/6/10 12:02 PM
 */
public class Lcof28 {
    /**
     * L.val == R.val
     * L.left.val == R.right.val
     * L.right.val == R.left.val
     */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return recursive(root.left, root.right);
    }

    public boolean recursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recursive(left.left, right.right) && recursive(left.right, right.left);
    }
}
