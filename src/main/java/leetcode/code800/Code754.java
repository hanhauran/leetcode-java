package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/28 17:12
 */

public class Code754 {
    public int reachNumber(int target) {
        if (target < 0) {
            return reachNumber(-target);
        }

        int res = 0, i = 0;
        while (res < target) {
            i++;
            res += i;
        }

        if ((res - target) % 2 == 0) {
            return i;
        }

        return i % 2 == 0 ? i + 1 : i + 2;
    }

    public static void main(String[] args) {
        Code754 code = new Code754();
        System.out.println(code.reachNumber(2));
    }
}
