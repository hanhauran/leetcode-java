package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/11 16:00
 */

public class Code633 {
    public boolean judgeSquareSum(int c) {
        int xMax = (int) Math.sqrt(c);
        for (int i = xMax; i >= xMax / 2; i--) {
            if (part(c, i)) {
                return true;
            }
        }

        return false;
    }

    private boolean part(int c, int x) {
        double res = Math.sqrt(c - x * x);
        return res == ((double) ((int) res));
    }

    public static void main(String[] args) {
        Code633 code = new Code633();
        System.out.println(code.judgeSquareSum(100));
    }
}
