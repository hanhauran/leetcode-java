package leetcode.code600;

/**
 * @author hr.han
 * @date 2018/12/5 20:16
 */

public class Code507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }

        int ans = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                ans += i + num / i;
            }
        }

        return ans == num;
    }

    public static void main(String[] args) {
        Code507 code = new Code507();
        System.out.println(code.checkPerfectNumber(28));
    }
}
