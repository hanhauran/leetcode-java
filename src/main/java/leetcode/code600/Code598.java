package leetcode.code600;

/**
 * @author hr.han
 * @date 2018/12/11 14:12
 */

public class Code598 {
    public int maxCount(int m, int n, int[][] ops) {
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            x = Math.min(x, ops[i][0]);
            y = Math.min(y, ops[i][1]);
        }
        return (x > m ? m : x) * (y > n ? n : y);
    }

    public static void main(String[] args) {
        Code598 code = new Code598();
    }
}
