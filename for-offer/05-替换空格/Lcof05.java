/**
 * Lcof05
 */
public class Lcof05 {

  public String replaceSpace(String s) {
    if (s == null) {
      return null;
    }

    char[] charArr = s.toCharArray();
    int len = charArr.length;
    int spaceNum = 0;
    for (int i = 0; i < len; i++) {
      char ch = charArr[i];
      if (ch == ' ') {
        spaceNum ++;
      }
    }

    if (spaceNum == 0) {
      return s;
    }

    int newLen = len + 2 * spaceNum;
    char[] newChars = new char[newLen];
    for (int i = len - 1, j = newLen - 1; i >= 0; i--) {
      char ch = charArr[i];
      if (ch == ' ') {
        newChars[j--] = '0';
        newChars[j--] = '2';
        newChars[j--] = '%';
      } else {
        newChars[j--] = ch;
      }
    }

    return String.valueOf(newChars);
  }

  public void test() {
    String s1 = "we are happy ! !";
    System.out.println(replaceSpace(s1));

    String s2 = "";
    System.out.println(replaceSpace(s2));

    String s3 = null;
    System.out.println(replaceSpace(s3));

    String s4 = "   ";
    System.out.println(replaceSpace(s4));
  }

  public static void main(String[] args) {
    Lcof05 lcof05 = new Lcof05();
    lcof05.test();
  }
}