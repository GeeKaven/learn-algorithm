package moe.tawawa.leetcode.q605_Can_Place_Flowers;

/**
 * @author GeeKaven
 * @date 2021/1/1 19:35
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int beginOneIndex = Integer.MAX_VALUE - 1;
        int endOneIndex = Integer.MIN_VALUE;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                beginOneIndex = i;
                break;
            }
        }

        if (beginOneIndex == Integer.MAX_VALUE - 1) {
            return (flowerbed.length + 1) / 2 >= n;
        }

        for (int i = flowerbed.length - 1; i >= 0 ; i--) {
            if (flowerbed[i] == 1) {
                endOneIndex = i;
                break;
            }
        }

        int canPlace = beginOneIndex / 2 + (flowerbed.length - 1 - endOneIndex) / 2;

        int zeroCount = 0;
        for (int i = beginOneIndex + 1; i <= endOneIndex; i++) {
            if (flowerbed[i] == 0) {
                zeroCount++;
            } else if (flowerbed[i] == 1) {
                canPlace += (zeroCount - 1) / 2;
                zeroCount = 0;
            }
        }
        return canPlace >= n;
    }

    // 如果能插入则是当前点的左，自己，右都是0
    // 插入后变1， 然后总数加1
    // 注意边界的情况
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if ((i == 0 || flowerbed[i - 1] == 0)
                    && ((i == flowerbed.length - 1 || flowerbed[i + 1] == 0))
                    && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                count++;
                if (count >= n) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPlaceFlowers1(new int[]{1,0,0,0,1}, 1));
    }
}
