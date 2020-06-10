package foroffer;

/**
 * @author geekaven
 * @date 2020/6/10 11:57 AM
 */
public class Lcof17 {
    // 虽然能通过，
    // 但是可能存在大数问题，用字符串模拟加法
    // 或者可以转换为n位数上的0～9全排列
    public int[] printNumbers(int n) {
        double length = Math.pow(10, n) - 1;
        int[] res = new int[(int)length];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    // 长度为n的数组，0～9全排列
    class Lcof17_S1 {
        public void printNumbers(int n) {
            int[] num = new int[n];
            digits(num, n, 0);
        }

        private void digits(int[] num, int length, int index) {
            if (index > length - 1) {
                printStr(num);
                return;
            }
            for (int i = 0; i < 10; i++) {
                num[index] = i;
                digits(num, length, index + 1);
            }
        }

        private void printStr(int[] num) {
            StringBuffer str = new StringBuffer();
            boolean hasBegin = false;
            for (int i = 0; i < num.length; i++) {
                if (num[i] != 0) {
                    hasBegin = true;
                }
                if (!hasBegin) {
                    continue;
                }
                str.append(num[i]);
            }
            System.out.println(str.toString());
        }
    }
}
