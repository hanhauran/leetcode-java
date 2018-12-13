package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/13 16:59
 */

public class Code717 {
    public boolean isOneBitCharacter(int[] bits) {
        int start = 0;
        while (start < bits.length - 2) {
            start = helper(bits, start);
        }

        if (start == bits.length - 1) {
            return true;
        } else {
            return bits[start] == 0;
        }
    }

    private int helper(int[] bits, int start) {
        if (bits[start] == 0) {
            return ++start;
        } else {
            return start + 2;
        }
    }

    public static void main(String[] args) {
        Code717 code = new Code717();
        System.out.println(code.isOneBitCharacter(new int[]{0, 0, 0}));
    }
}
