class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class Lcof07 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0) {
      return null;
    }
    return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  public TreeNode constructTree(int[] preorder, int startPreorder, int endPreorder, int[] inorder, int startInorder,
      int endInorder) {
    int rootValue = preorder[startPreorder];
    TreeNode root = new TreeNode(rootValue);

    if (startPreorder == endPreorder) {
      if (startInorder == endInorder && preorder[startPreorder] == inorder[startInorder]) {
        return root;
      }
    }

    int rootInorder = startInorder;
    while (rootInorder < endInorder && inorder[rootInorder] != rootValue) {
      rootInorder++;
    }

    int leftLen = rootInorder - startInorder;
    int leftEndPreorder = startPreorder + leftLen;
    if (leftLen > 0) {
      root.left = constructTree(preorder, startPreorder + 1, leftEndPreorder, inorder, startInorder, rootInorder - 1);
    }
    if (leftLen < endPreorder - startPreorder) {
      root.right = constructTree(preorder, leftEndPreorder + 1, endPreorder, inorder, rootInorder + 1, endInorder);
    }

    return root;
  }

  public void test() {
    int[] preorder = {1,2,4,7,3,5,6,8};
    int[] inorder = {4,7,2,1,5,3,8,6};
    TreeNode root = buildTree(preorder, inorder);
    System.out.println(root.val);

  }

  public static void main(String[] args) {
    Lcof07 lcof07 = new Lcof07();
    lcof07.test();;
  }
}