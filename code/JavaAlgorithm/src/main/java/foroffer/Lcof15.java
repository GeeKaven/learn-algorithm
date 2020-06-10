package foroffer;

/**
 * @author geekaven
 * @date 2020/6/10 11:56 AM
 */
public class Lcof15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }
}
