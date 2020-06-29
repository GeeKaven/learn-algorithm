package foroffer;

public class Lcof42 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currSum = 0;
        int greatSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (currSum <= 0) {
                currSum = num;
            } else {
                currSum += num;
            }
            
            if (currSum > greatSum) {
                greatSum = currSum;
            }
        }
        return greatSum;
    }
}
