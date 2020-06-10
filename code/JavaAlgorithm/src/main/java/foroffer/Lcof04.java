package foroffer;

/**
 * @author geekaven
 * @date 2020/6/10 11:50 AM
 */
public class Lcof04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean res = false;
        if (matrix != null && matrix.length > 0 && matrix[0] != null) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            if (rows > 0 && cols > 0) {
                int row = 0, col = cols - 1;
                while (row < rows && col >= 0) {
                    int num = matrix[row][col];
                    if (num > target) {
                        col = col - 1;
                    } else if (num < target) {
                        row = row + 1;
                    } else {
                        res = true;
                        break;
                    }
                }
            }
        }
        return res;
    }

//    public void test() {
//        int[][] test = {
//                { 1, 4, 7, 11, 15 },
//                { 2, 5, 8, 12, 19 },
//                { 3, 6, 9, 16, 22 },
//                { 10, 13, 14, 17, 24 },
//                { 18, 21, 23, 26, 30 },
//        };
//        int[][] test2 = { {} };
//        int[][] test3 = { { 1, 2, 3 } };
//        int[][] test4 = {};
//        assert true == findNumberIn2DArray(test, 5);
//        assert false == findNumberIn2DArray(test, 20);
//        assert false == findNumberIn2DArray(null, 7);
//        assert false == findNumberIn2DArray(test2, 1);
//        assert true  == findNumberIn2DArray(test3, 1);
//        assert false == findNumberIn2DArray(test4, 1);
//
//    }
}
