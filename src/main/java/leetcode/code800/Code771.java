package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/29 14:56
 */

public class Code771 {
    public int numJewelsInStones(String j, String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (j.contains(String.valueOf(c))) {
                res++;
            }
        }
        return res;
    }
}
