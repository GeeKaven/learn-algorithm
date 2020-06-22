package foroffer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lcof38 {
    public String[] permutation(String s) {
        if (s == null) return null;
        if (s.isEmpty()) return new String[]{};
        char[] str = s.toCharArray();
        List<String> result = new ArrayList<>();
        permutation(result, str, 0);
        return result.toArray(new String[]{});
    }

    public void permutation(List<String> result, char[] str, int begin) {
        if (begin >= str.length) {
            result.add(String.valueOf(str));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = begin; i < str.length; i++) {
            if (set.contains(str[i])) {
                continue;
            }
            set.add(str[i]);

            char temp = str[i];
            str[i] = str[begin];
            str[begin] = temp;

            permutation(result, str, begin + 1);

            temp = str[begin];
            str[begin] = str[i];
            str[i] = temp;
        }
    }

    @Test
    public void test() {
        String s = "abc";
        String[] res = permutation(s);
        System.out.println(Arrays.toString(res));
    }
}
