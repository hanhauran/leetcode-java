package leetcode;

/**
 * @author hr.han
 * @date 2019/1/16 18:17
 */

public class Interval {
    public int start;
    public int end;
    public Interval() {
        start = end = 0;
    }
    public Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public String toString() {
        return "Interval{s=" + start + ", e=" + end + "}";
    }
}
