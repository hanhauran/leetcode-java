package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/5 14:50
 */

@Level(Levels.EASY)
public class Code953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], orders) > 0) {
                return false;
            }
        }

        return true;
    }

    private int compare(String a, String b, int[] orders) {
        int len1 = a.length();
        int len2 = b.length();
        int max = Math.min(len1, len2);
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int k = 0;
        while (k < max) {
            char at = as[k];
            char bt = bs[k];
            if (at != bt) {
                return orders[at - 'a'] - orders[bt - 'a'];
            }
            k++;
        }
        return len1 - len2;
    }

    public static void main(String[] args) {
        Code953 code = new Code953();
        System.out.println("word".compareTo("wordl"));
    }
}
