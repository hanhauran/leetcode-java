package leetcode.code500;

import java.util.Arrays;

/**
 * @author hr.han
 * @date 2018/12/3 10:14
 */

public class Code475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int[] tmp = new int[houses.length];
        int start = 0, end = houses.length;

        for (int i = 0; i < houses.length; i++) {
            if (houses[i] <= heaters[0]) {
                tmp[i] = heaters[0] - houses[i];
                start = i;
            } else {
                break;
            }
        }

        for (int i = houses.length - 1; i >= 0; i--) {
            if (houses[i] >= heaters[heaters.length - 1]) {
                tmp[i] = houses[i] - heaters[heaters.length - 1];
                end = i;
            } else {
                break;
            }
        }

        int heaterStart = 0;
        for (int i = start + 1; i < end; i++) {
            heaterStart = helper(tmp, houses, i, heaterStart, heaters);
        }

        int result = Integer.MIN_VALUE;
        for (int i : tmp) {
            if (result < i) {
                result = i;
            }
        }

        return result;
    }

    private int helper(int[] tmp, int[] houses, int index, int start, int[] heaters) {
        for (int i = start; i < heaters.length; i++) {
            if (houses[index] >= heaters[i] && houses[index] <= heaters[i + 1]) {
                start = i;
                tmp[index] = Math.min(houses[index] - heaters[i], heaters[i + 1] - houses[index]);
                break;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        Code475 code = new Code475();
        System.out.println(code.findRadius(new int[]{1,2,3,5,15},
                new int[]{2, 30}));
    }
}
