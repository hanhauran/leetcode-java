package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

/**
 * @author hr.han
 * @date 2019/1/16 17:38
 */

@Level(Levels.MEDIUM)
@Question(
        value = "给定一个非负整数数组，你最初位于数组的第一个位置。" +
                "数组中的每个元素代表你在该位置可以跳跃的最大长度。" +
                "判断你是否能够到达最后一个位置。",
        input = "[2,3,1,1,4], [3,2,1,0,4]",
        output = "true, false"
)
public class Code55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (max == i && i != nums.length - 1) {
                    return false;
                }
            } else {
                max = Math.max(max, nums[i] + i);
            }
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        Code55 code = new Code55();
        System.out.println(code.canJump(new int[]{3, 2, 2, 0, 4}));
    }
}
