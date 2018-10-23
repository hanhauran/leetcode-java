package leetcode.code100;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code69 {
    public int mySqrt(int x) {
        int result = x;
        while (result * result > x) {
            result = (result + x / result) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Code69 code = new Code69();
        System.out.println(code.mySqrt(18));
    }
}
