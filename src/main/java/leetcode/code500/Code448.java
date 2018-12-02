package leetcode.code500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/12/1 17:13
 */

public class Code448 {
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int[] helper = new int[nums.length + 1];

        for (int i : nums) {
            helper[i]++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < helper.length; i++) {
            if (helper[i] == 0) {
                list.add(i);
            }
        }

        return list;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) {
            return Collections.singletonList(1);
        }

        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tmp) {
                continue;
            }

            for (int j = tmp + 1; j < nums[i]; j++) {
                result.add(j);
            }
            tmp = nums[i];
        }

        if (nums[0] != 1) {
            for (int i = 1; i < nums[0]; i++) {
                result.add(i);
            }
        }

        if (nums[nums.length - 1] != nums.length) {
            for (int i = nums[nums.length - 1] + 1; i <= nums.length; i++) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Code448 code = new Code448();
        System.out.println(code.findDisappearedNumbers2(new int[]{}));
    }
}
