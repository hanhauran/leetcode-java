package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/13 11:38
 */

public class Code693 {
    public boolean hasAlternatingBits(int n) {
        if (n == 0) {
            return true;
        }

        int flag = n & 1;
        n = n >>> 1;
        while (n != 0) {
            int tmp = n & 1;
            n = n >>> 1;
            if (flag != tmp) {
                flag = tmp;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code693 code = new Code693();
        System.out.println(code.hasAlternatingBits(5));
    }
}
