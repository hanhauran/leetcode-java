package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2019/1/20 11:09
 */

@Level(Levels.MEDIUM)
@Question(
        value = "给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。",
        input = "[1,1,1,2,2,2,3]",
        output = "[1,1,2,2,3,...]"
)
public class Code80 {
    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k < 2 || nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int tag = nums[0];
        int count = 0;
        int len = 0;
        while (right < nums.length) {
            if (nums[right] == tag) {
                count++;
                if (count <= 2) {
                    len++;
                    nums[left++] = nums[right++];
                } else {
                    while (right < nums.length && nums[right] == tag) {
                        right++;
                    }
                }
            } else {
                tag = nums[right];
                count = 0;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Code80 code = new Code80();
        int[] arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(code.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
