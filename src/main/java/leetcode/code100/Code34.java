package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/7 15:29
 */

@Level(Levels.MEDIUM)
@Question("在排序数组中查找元素的第一个和最后一个位置，要求O(log n)复杂度")
public class Code34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int index = -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                index = mid;
                break;
            }
        }

        if (index == -1) {
            return new int[]{-1, -1};
        }

        int[] res = new int[2];

        i = 0;
        j = index;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        res[0] = i;

        i = index;
        j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        res[1] = j;

        return res;
    }

    public static void main(String[] args) {
        Code34 code = new Code34();
        System.out.println(Arrays.toString(code.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }
}
