package leetcode.code400;

/**
 * @author hr.han
 * @date 2018/11/28 20:12
 */

public class Code371_GetSumUsingBitOps {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 非进位之和
        int sum = a ^ b;
        // 进位
        int carry = (a & b) << 1;
        // 非进位之和 和 进位值 相加
        return getSum(sum, carry);
    }
}
