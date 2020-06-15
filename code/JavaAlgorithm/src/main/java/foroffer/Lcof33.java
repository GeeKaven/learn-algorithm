package foroffer;

import java.util.Arrays;
import java.util.List;

public class Lcof33 {
    public boolean verifyPostorder(int[] postorder) {

        if (postorder == null) {
            return false;
        }

        if (postorder.length == 0) {
            return true;
        }

        return checkPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean checkPostorder(int[] postorder, int start, int end) {
        int root = postorder[end];
        int i = start;
        while (i < end) {
            if (postorder[i] > root) {
                break;
            }
            i++;
        }
        int j = i;
        while (j < end) {
            if (postorder[j] < root) {
                return false;
            }
            j++;
        }
        boolean left = true;
        if (i > start) {
            left = checkPostorder(postorder, start, i - 1);
        }
        boolean right = true;
        if (i < end) {
            right = checkPostorder(postorder, i, end - 1);
        }
        return left && right;
    }
}
