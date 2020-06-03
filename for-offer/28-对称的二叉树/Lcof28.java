public class Lcof28 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

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

  public static void main(String[] args) {
    
  }
}