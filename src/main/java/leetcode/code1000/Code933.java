package leetcode.code1000;

import finder.annotation.Level;
import finder.annotation.Levels;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author hr.han
 * @date 2019/1/5 12:46
 */

@Level(Levels.EASY)
public class Code933 {
    class RecentCounter {
        private LinkedList<Integer> cache;
        public RecentCounter() {
            cache = new LinkedList<>();
        }

        public int ping(int t) {
            cache.addLast(t);
            int count = 0;
            Iterator<Integer> iter = cache.descendingIterator();
            while (iter.hasNext()) {
                if (iter.next() >= t - 3000) {
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }
    }
}
