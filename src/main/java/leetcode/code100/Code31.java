package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/7 8:38
 */

@Level(Levels.MEDIUM)
@Question("给出数组对应的数字的字典序下一个数字数组，若无，则升序排列")
public class Code31 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                int index = lookFor(nums, nums[i - 1], i);
                swap(nums, i - 1, index);
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }

        Arrays.sort(nums);
    }

    private int lookFor(int[] nums, int largeThen, int start) {
        int res = start;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > largeThen && nums[i] < nums[res]) {
                res = i;
            }
        }
        return res;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        Code31 code = new Code31();
        int[] arr = new int[]{1,3,2};
        code.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
