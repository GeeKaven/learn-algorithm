public class Lcof15 {
  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      n = (n - 1) & n;
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Lcof15 lcof15 = new Lcof15();
    System.out.println(lcof15.hammingWeight(1));
    System.out.println(lcof15.hammingWeight(9));
  }
}