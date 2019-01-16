package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;
import leetcode.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/16 18:04
 */

@Level(Levels.MEDIUM)
@Question("给出一个区间的集合，请合并所有重叠的区间。")
public class Code56 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return Collections.emptyList();
        }

        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        List<Interval> res = new ArrayList<>(intervals.size() * 4 / 3 + 1);
        for (Interval interval : intervals) {
            if (res.isEmpty()) {
                res.add(interval);
            } else {
                int last = res.get(res.size() - 1).end;
                int nextStart = interval.start;
                if (last < nextStart) {
                    res.add(interval);
                } else {
                    if (interval.end > last) {
                        res.get(res.size() - 1).end = interval.end;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Code56 code = new Code56();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        System.out.println(code.merge(intervals));
    }
}
