package leetcode.code200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ihhr
 * @date 2018/11/7
 */

public class Code168 {
    public String convertToTitle2(int n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            int tmp = (n - 1) % 26;
            builder.insert(0, (char) (65 + tmp));
            n = (n - 1) / 26;
        }
        return builder.toString();
    }

    public String convertToTitle(int n) {
        List<Integer> list = convert(n, 26);
        StringBuilder builder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            builder.append((char) (64 + list.get(i)));
        }
        return builder.toString();
    }

    private List<Integer> convert(int n, int radix) {
        List<Integer> list = new ArrayList<>();

        while (n != 0) {
            list.add(n % radix);
            n /= radix;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) <= 0) {
                list.set(i, 26);
                list.set(i + 1, list.get(i + 1) - 1);
            }
        }

        if (list.get(list.size() - 1) == 0) {
            list.remove(list.size() - 1);
        }

        return list;
    }

    public static void main(String[] args) {
        Code168 code = new Code168();
        System.out.println(code.convert(702, 26));
        System.out.println(code.convertToTitle2(701));
    }
}
