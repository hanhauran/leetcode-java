package leetcode.code400;

/**
 * @author hr.han
 * @date 2018/11/29 10:13
 */

public class Code400 {
    public int findNthDigit(int n) {
        long wei = 0;
        int count = 1;
        while (true) {
            long tmp = wei + ((long) (9 * count * Math.pow(10, count - 1)));
            if (tmp >= n) {
                break;
            } else {
                wei = tmp;
                count++;
            }
        }

        long left = n - wei;
        System.out.println(left + " " + count);
        return part(((int) Math.pow(10, count - 1)) - 1, count, left);
    }

    private int part(long start, int count, long left) {
        long add = left / count;
        start += add;
        left = left % count;
        if (left == 0) {
            return (int) start % 10;
        } else {
            start++;
            left = count - left;
            while (left != 0) {
                start /= 10;
                left--;
            }
            return (int) start % 10;
        }
    }

    public static void main(String[] args) {
        Code400 code = new Code400();
        System.out.println(code.findNthDigit(1000000000));
    }
}
