package leetcode.code500;

/**
 * @author hr.han
 * @date 2018/12/3 8:44
 */

public class Code458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int loop = minutesToTest / minutesToDie;
        return  (int) Math.ceil(Math.log(buckets) / Math.log(loop + 1));
    }

    public static void main(String[] args) {
        Code458 code = new Code458();
        System.out.println(code.poorPigs(1000, 15, 60));
    }
}
