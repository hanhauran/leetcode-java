package leetcode.code500;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/11/30 16:01
 */

public class Code414 {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        List<Integer> win = new ArrayList<>(8);
        for (int cur : nums) {
            if (win.size() < 3) {
                if (! win.contains(cur)) {
                    win.add(cur);
                    win.sort(Comparator.comparingInt(item -> item));
                }
            } else {
                part(win, cur);
            }
        }

        if (win.size() < 3) {
            return win.get(win.size() - 1);
        } else {
            return win.get(0);
        }
    }

    private void part(List<Integer> win, int cur) {
        if (win.contains(cur)) {
            return;
        }

        if (cur > win.get(2)) {
            win.set(0, win.get(1));
            win.set(1, win.get(2));
            win.set(2, cur);
            return;
        }

        if (cur > win.get(1)) {
            win.set(0, win.get(1));
            win.set(1, cur);
            return;
        }

        if (cur > win.get(0)) {
            win.set(0, cur);
        }
    }

    public static void main(String[] args) {
        Code414 code = new Code414();
        System.out.println(code.thirdMax(new int[]{5,2,4,1,3,6,0}));
    }
}
