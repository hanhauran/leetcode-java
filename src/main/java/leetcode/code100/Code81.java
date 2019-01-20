package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Link;
import finder.annotation.Question;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/20 12:13
 */

@Level(Levels.MEDIUM)
@Question("[4,5,6,7,0,1,2,4] 这种数组(有重复)中寻找目标值")
@Link(Code33.class)
public class Code81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                break;
            }
        }

        boolean flag1 = Arrays.binarySearch(nums, 0, i + 1, target) >= 0;
        boolean flag2 = i + 1 < nums.length && Arrays.binarySearch(nums, i + 1, nums.length, target) >= 0;
        return flag1 | flag2;
    }

    public static void main(String[] args) {
        Code81 code = new Code81();
        System.out.println(code.search(new int[]{1}, 1));
    }
}
