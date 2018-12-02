package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/12/1 16:13
 */

public class Code441 {
    public int arrangeCoins(int n) {
        // x(x+1) < 2n
        int tmp = (int) Math.sqrt((long) 2 * n);
        long sum = tmp * (tmp + 1);
        while (sum > 2 * n) {
            tmp --;
            sum = tmp * (tmp + 1);
        }
        return tmp;
    }

    public static void main(String[] args) {
        Code441 code = new Code441();
        System.out.println(code.arrangeCoins(1804289383));
    }
}
