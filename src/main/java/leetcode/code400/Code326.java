package leetcode.code400;

/**
 * @author ihhr
 * @date 2018/11/27
 */

public class Code326 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && ((int) Math.pow(3, ((int) (Math.log(Integer.MAX_VALUE) / Math.log(3))))) % n == 0;
    }

    public static void main(String[] args) {
        Code326 code = new Code326();
        System.out.println(code.isPowerOfThree(81));
        System.out.println(((int) Math.pow(3, ((int) (Math.log(Integer.MAX_VALUE) / Math.log(3))))));
    }
}
