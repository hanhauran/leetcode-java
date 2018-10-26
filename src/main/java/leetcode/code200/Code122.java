package leetcode.code200;

/**
 * @author ihhr
 * @date 2018/10/26
 */

public class Code122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        return part(prices, 0);
    }

    public int part(int[] prices, int begin) {
        int max = 0;
        if (begin >= prices.length) {
            return max;
        }
        int min = prices[begin];
        int i;
        for (i = begin + 1; i < prices.length; i++) {
            if (prices[i] >= min) {
                int tmp = prices[i] - min;
                max += (tmp > 0 ? tmp : 0);
                min = prices[i];
            } else {
                break;
            }
        }
        max += part(prices, i);
        return max;
    }

    public static void main(String[] args) {
        Code122 code = new Code122();
        System.out.println(code.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
