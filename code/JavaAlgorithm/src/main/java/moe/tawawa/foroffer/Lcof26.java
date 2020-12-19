package moe.tawawa.foroffer;

import model.TreeNode;

/**
 * @author geekaven
 * @date 2020/6/10 12:01 PM
 */
public class Lcof26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        boolean isSubTree = false;

        if (A != null && B != null) {
            if (A.val == B.val) {
                isSubTree = checkSubTree(A, B);
            }
            if (!isSubTree) {
                isSubTree = isSubStructure(A.left, B);
            }
            if (!isSubTree) {
                isSubTree = isSubStructure(A.right, B);
            }
        }

        return isSubTree;
    }

    public boolean checkSubTree(TreeNode rootA, TreeNode rootB) {
        if (rootB == null) {
            return true;
        }
        if (rootA == null) {
            return false;
        }
        if (rootA.val != rootB.val) {
            return false;
        }
        return checkSubTree(rootA.left, rootB.left) && checkSubTree(rootA.right, rootB.right);
    }
}
