package leetcode.code100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code38 {

    private static final List<String> cache = new ArrayList<>();

    static {
        cache.add("1");
        cache.add("11");
        cache.add("21");
        cache.add("1211");
    }

    public String countAndSay(int n) {
        if (n < cache.size()) {
            return cache.get(n - 1);
        }

        for (int i = cache.size() - 1; i < n; i++) {
            String tmp = String.valueOf(cache.get(i));
            char[] array = tmp.toCharArray();

            StringBuilder builder = new StringBuilder();
            for (int index = 0; index < array.length; ) {
                char cur = array[index];
                int j;
                for (j = index + 1; j < array.length; ) {
                    if (array[j] == cur) {
                        j++;
                    } else {
                        break;
                    }
                }
                builder.append(j - index).append(cur);
                index = j;
            }

            cache.add(builder.toString());
        }

        return cache.get(n - 1);
    }

    public static void main(String[] args) {
        Code38 code = new Code38();
        System.out.println(code.countAndSay(6));
    }
}
