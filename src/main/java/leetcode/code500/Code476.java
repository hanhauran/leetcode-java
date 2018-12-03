package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/12/3 11:06
 */

public class Code476 {
    public int findComplement2(int num) {
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }

    public int findComplement(int num) {
        int result = 0;
        int tmp;
        int cur = 0;
        while (num != 0) {
            tmp = num & 1;
            if (tmp == 0) {
                result += Math.pow(2, cur);
            }
            cur++;
            num >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Code476 code = new Code476();
        System.out.println(code.findComplement2(Integer.MIN_VALUE));
    }
}
