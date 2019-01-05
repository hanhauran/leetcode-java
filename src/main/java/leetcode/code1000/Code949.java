package leetcode.code1000;

import finder.annotation.Interesting;
import finder.annotation.Level;
import finder.annotation.Levels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/5 14:12
 */

@Level(Levels.EASY)
@Interesting("全排列")
public class Code949 {
    public String largestTimeFromDigits(int[] a) {
        List<int[]> res = new ArrayList<>();
        helper(a, 0, a.length - 1, res);
        int[] max = null;
        for (int[] arr : res) {
            if (arr[0] < 24 && arr[1] < 60) {
                if (max == null) {
                    max = arr;
                } else {
                    if ((max[0] < arr[0]) || (max[0] == arr[0] && max[1] < arr[1])) {
                        max = arr;
                    }
                }
            }
        }

        return max == null ? "" : String.format("%02d:%02d", max[0], max[1]);
    }

    private void helper(int[] arr, int start, int end, List<int[]> res) {
        if (start == end) {
            int[] r = new int[2];
            r[0] = arr[0] * 10 + arr[1];
            r[1] = arr[2] * 10 + arr[3];
            res.add(r);
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            helper(arr, start + 1, end, res);
            swap(arr, i, start);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        Code949 code = new Code949();
        List<int[]> res = new ArrayList<>();
        code.helper(new int[]{1,2,3,4}, 0, 3, res);
        res.forEach(item -> System.out.println(Arrays.toString(item)));
    }
}
