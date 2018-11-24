package leetcode.code300;

/**
 * @author ihhr
 * @date 2018/11/24
 */

public class Code231 {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }

        return Integer.bitCount(n) == 1;

//        int count = 0;
//        while (n != 0) {
//            int tmp = n & 1;
//            if (tmp == 1) {
//                count++;
//            }
//            n = n >>> 1;
//        }
//
//        return count == 1;
    }

    public static void main(String[] args) {
        Code231 code = new Code231();
        System.out.println(code.isPowerOfTwo(-2147483646));
    }
}
