package moe.tawawa.foroffer;

/**
 * @author geekaven
 * @date 2020/6/10 11:59 AM
 */
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
}
