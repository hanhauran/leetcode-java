package leetcode.code300;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code258 {
    public int addDigits1(int num) {
        int res = cal(num);
        return res > 9 ? addDigits1(res) : res;
    }

    public int addDigits2(int num) {
        while (num > 9) {
            num = cal(num);
        }
        return num;
    }

    private int cal(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Code258 code = new Code258();
        System.out.println(code.addDigits1(38));
    }
}
