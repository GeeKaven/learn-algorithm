package moe.tawawa.leetcode.q012_Integer_to_Roman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GeeKaven
 * @date 2020/12/21 15:11
 */
public class Solution {
    public String intToRoman(int num) {
        List<StringBuilder> ans = new ArrayList<>();
        List<Map<Integer, String>> romanMaps = new ArrayList<>();
        romanMaps.add(new HashMap<Integer, String>() {{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
        }});
        romanMaps.add(new HashMap<Integer, String>() {{
            put(1, "X");
            put(4, "XL");
            put(5, "L");
            put(9, "XC");
        }});
        romanMaps.add(new HashMap<Integer, String>() {{
            put(1, "C");
            put(4, "CD");
            put(5, "D");
            put(9, "CM");
        }});
        romanMaps.add(new HashMap<Integer, String>() {{
            put(1, "M");
        }});
        int help = 0;
        while (num > 0) {
            int digit = num % 10;
            Map<Integer, String> romanMap = romanMaps.get(help);
            StringBuilder builder = new StringBuilder();
            while (digit > 0) {
                if (digit < 4) {
                    builder.append(romanMap.get(1));
                    digit = digit - 1;
                } else if (digit == 4) {
                    builder.append(romanMap.get(4));
                    digit = digit - 4;
                } else if (digit == 5) {
                    builder.append(romanMap.get(5));
                    digit = digit - 5;
                } else if (digit < 9) {
                    builder.append(romanMap.get(5));
                    digit = digit - 5;
                } else if (digit == 9) {
                    builder.append(romanMap.get(9));
                    digit = digit - 9;
                }
            }
            ans.add(builder);
            num = num / 10;
            help++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = ans.size() - 1; i >= 0; i--) {
            res.append(ans.get(i).toString());
        }
        return res.toString();
    }

    // 贪心算法，类似找零钱问题
    public String intToRoman1(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int index = 0;
        StringBuilder ans = new StringBuilder();
        while (index < 13) {
            if (num >= nums[index]) {
                ans.append(romans[index]);
                num = num - nums[index];
            } else {
                index++;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.intToRoman1(1994));
    }
}
