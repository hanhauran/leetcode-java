package leetcode.code600;

/**
 * @author hr.han
 * @date 2018/12/3 15:15
 */

public class Code504 {
    public String convertToBase72(int num) {
        return Integer.toString(num, 7);
    }

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = num >= 0;
        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        return flag ? sb.reverse().toString() : sb.append('-').reverse().toString();
    }

    public static void main(String[] args) {
        Code504 code = new Code504();
        System.out.println(code.convertToBase7(-7));
    }
}
