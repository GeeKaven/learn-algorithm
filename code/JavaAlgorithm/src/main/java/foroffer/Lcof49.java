package foroffer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lcof49 {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] uglyNumArr = new int[n];
        uglyNumArr[0] = 1;
        int nextIndex = 1;
        int multiply2Index = 0;
        int multiply3Index = 0;
        int multiply5Index = 0;
        while (nextIndex < n) {
            int minNum = minNum(uglyNumArr[multiply2Index] * 2, uglyNumArr[multiply3Index] * 3, uglyNumArr[multiply5Index] * 5);
            uglyNumArr[nextIndex] = minNum;
            while (uglyNumArr[multiply2Index] * 2 <= minNum) {
                multiply2Index++;
            }
            while (uglyNumArr[multiply3Index] * 3 <= minNum) {
                multiply3Index++;
            }
            while (uglyNumArr[multiply5Index] * 5 <= minNum) {
                multiply5Index++;
            }
            nextIndex++;
        }

        return uglyNumArr[n - 1];
    }

    public int minNum(int n1, int n2, int n3) {
        if (n1 < n2) {
            return Math.min(n1, n3);
        } else {
            return Math.min(n2, n3);
        }
    }

    @Test
    public void test() {
        Assertions.assertEquals(12, nthUglyNumber(10));
    }
}
