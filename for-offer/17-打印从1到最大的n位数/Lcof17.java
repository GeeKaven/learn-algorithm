import java.util.Arrays;

// 虽然能通过， 
// 但是可能存在大数问题，用字符串模拟加法
// 或者可以转换为n位数上的0～9全排列
public class Lcof17 {
  public int[] printNumbers(int n) {
    double length = Math.pow(10, n) - 1;
    int[] res = new int[(int)length];
    for (int i = 0; i < res.length; i++) {
      res[i] = i + 1;
    }
    return res;
  }

  public static void main(String[] args) {
    Lcof17 lcof17 = new Lcof17();
    System.out.println(Arrays.toString(lcof17.printNumbers(3)));
    Lcof17_S1 lcof17_S1 = new Lcof17_S1();
    lcof17_S1.printNumbers(3);
  }
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