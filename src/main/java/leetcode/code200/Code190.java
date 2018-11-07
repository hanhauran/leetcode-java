package leetcode.code200;

/**
 * @author ihhr
 * @date 2018/11/7
 */

public class Code190 {
    public int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + (n & 1);
            n = n >> 1;
        }

        return result;

//        String val = Integer.toBinaryString(n);
//        StringBuilder builder = new StringBuilder(val);
//        while (builder.length() != 32) {
//            builder.insert(0, '0');
//        }
//        val = builder.toString();
//        int result = 0;
//        int cur = 1;
//        for (int i = 0; i < val.length(); i++) {
//            if (val.charAt(i) == '1') {
//                result += cur;
//            }
//            cur *= 2;
//        }
//        return result;
    }

    public static void main(String[] args) {
        Code190 code = new Code190();
        System.out.println(code.reverseBits(43261596));
    }
}
