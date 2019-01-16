package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;
import leetcode.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/16 18:16
 */

@Level(Levels.HARD)
@Question("给出一个无重叠的 ，按照区间起始端点排序的区间列表。" +
        "在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。")
public class Code57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }

        List<Interval> res = new ArrayList<>();

        if (intervals == null || intervals.isEmpty()) {
            res.add(newInterval);
            return res;
        }

        int ns = newInterval.start, ne = newInterval.end;
        if (ns > intervals.get(intervals.size() - 1).end) {
            res.addAll(intervals);
            res.add(newInterval);
            return res;
        } else if (ns < intervals.get(0).start && ne < intervals.get(0).start) {
            res.add(newInterval);
            res.addAll(intervals);
            return res;
        }

        boolean flag = true;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                res.add(interval);
                continue;
            }

            if (interval.start > newInterval.end) {
                if (flag) {
                    res.add(new Interval(ns, ne));
                    flag = false;
                }
                res.add(interval);
                continue;
            }

            ns = Math.min(ns, interval.start);
            ne = Math.max(ne, interval.end);
            flag = true;
        }

        if (flag) {
            res.add(new Interval(ns, ne));
        }

        return res;
    }

    public static void main(String[] args) {
        Code57 code = new Code57();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(8, 9));
        System.out.println(code.insert(list, new Interval(5, 5)));
    }
}
