package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;
import finder.annotation.Question;

/**
 * @author hr.han
 * @date 2019/1/7 10:58
 */

@Level(Levels.MEDIUM)
@Question("[4,5,6,7,0,1,2] 这种数组(无重复)中寻找目标值")
public class Code33 {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (i == j) {
                return nums[i] == target ? i : -1;
            }

            if (i + 1 == j) {
                return nums[i] == target ? i : (nums[j] == target ? j : -1);
            }

            int mid = i + (j - i) / 2;
            if (target > nums[mid]) {
                if (nums[i] < nums[mid]) {
                    i = mid + 1;
                } else if (nums[i] > nums[mid]) {
                    if (target < nums[i]) {
                        i = mid + 1;
                    } else if (target > nums[i]) {
                        j = mid - 1;
                    } else {
                        return i;
                    }
                }
            } else if (target < nums[mid]) {
                if (nums[i] < nums[mid]) {
                    if (target < nums[i]) {
                        i = mid + 1;
                    } else if (target > nums[i]) {
                        j = mid - 1;
                    } else {
                        return i;
                    }
                } else if (nums[i] > nums[mid]) {
                    j = mid - 1;
                } else {
                    return i;
                }
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Code33 code = new Code33();
        System.out.println(code.search(new int[]{1,3,5}, 3));
    }
}
