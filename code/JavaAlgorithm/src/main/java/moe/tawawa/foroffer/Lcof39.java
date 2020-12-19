package moe.tawawa.foroffer;

public class Lcof39 {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int x = 0;
        for (int num : nums) {
            if (vote == 0) {
                x = num;
            }
            if (num == x) {
                vote += 1;
            } else {
                vote -=1;
            }
        }
        return x;
    }
}
