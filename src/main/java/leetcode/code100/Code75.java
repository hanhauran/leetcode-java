package leetcode.code100;

import finder.annotation.Interesting;
import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/18 19:57
 */

@Level(Levels.MEDIUM)
@Question("给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。" +
        "此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。")
@Interesting
public class Code75 {
    @Interesting
    public void sortColors2(int[] nums) {
        int left = 0, cur = 0, right = nums.length - 1;
        while (cur <= right) {
            if (nums[cur] == 0) {
                nums[cur] = nums[left];
                nums[left] = 0;
                left++;
                cur++;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                nums[cur] = nums[right];
                nums[right] = 2;
                right--;
            }
        }
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        quick(nums, 0);
        quick(nums, 1);
    }

    private void quick(int[] nums, int divide) {
        int i = -1, j = 0;
        while (j < nums.length) {
            if (nums[j] > divide) {
                j++;
            } else {
                swap(nums, ++i, j++);
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        Code75 code = new Code75();
        code.sortColors2(new int[]{2,0,2,1,1,0});
    }
}
