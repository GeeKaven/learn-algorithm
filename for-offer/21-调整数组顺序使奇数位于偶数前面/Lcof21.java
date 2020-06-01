import java.util.Arrays;

public class Lcof21 {
  public int[] exchange(int[] nums) {
    
    if (nums == null) {
      return null;
    }

    if (nums.length == 0) {
      return new int[]{};
    }

    int begin = 0;
    int end = nums.length - 1;

    while (begin < end) {
      while (begin < end && checkOdd(nums[begin])) {
        begin++;
      }
      while (end > begin && !checkOdd(nums[end])) {
        end--;
      }
      if (begin < end) {
        int temp = nums[begin];
        nums[begin] = nums[end];
        nums[end] = temp;
      }
    }

    return nums;
  }

  public boolean checkOdd(int num) {
    return (num & 1) == 1;
  }

  public static void main(String[] args) {
    Lcof21 lcof21 = new Lcof21();
    int[] nums = {4,2,1,3,5,6,8,3};
    System.out.println(Arrays.toString(lcof21.exchange(nums)));
  }
}