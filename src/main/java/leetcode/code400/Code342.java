/*
 * @Author: hr.han 
 * @Date: 2018-11-28 18:24:05 
 * @Last Modified by: hr.han
 * @Last Modified time: 2018-11-28 18:46:31
 */
package leetcode.code400;

public class Code342 {
    public boolean isPowerOfFour(int num) {
        if (num == 1) {
            return true;
        }

        if (num <= 0) {
            return false;
        } 

        if (num % 4 != 0) {
            return false;
        }

        return num / 4 == 1 ? true : isPowerOfFour(num / 4);
    }

    public boolean isPowerOfFour2(int num) {
        return num <= 0 ? false
            : ((int) Math.pow(4, ((int) (Math.log(num) / Math.log(4))))) == num;
    }

    public static void main(String[] args) {
        Code342 code = new Code342();
        System.out.println(code.isPowerOfFour(5));
        System.out.println((int) Math.pow(2, ((int) (Math.log(Integer.MAX_VALUE) / Math.log(2)))));
        int a = 0x55555555;
        System.out.println(a);
    }
}
 