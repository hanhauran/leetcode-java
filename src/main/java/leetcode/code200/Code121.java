package leetcode.code200;

/**
 * @author ihhr
 * @date 2018/10/26
 */

public class Code121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int max = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int tmp = prices[i] - min;
                max = (tmp > max ? tmp : max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Code121 code = new Code121();
        System.out.println(code.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
