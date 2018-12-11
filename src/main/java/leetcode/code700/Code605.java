package leetcode.code700;

import annotation.Fucked;

/**
 * @author hr.han
 * @date 2018/12/11 15:06
 */

@Fucked
public class Code605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;
        int index = -1;
        while (true) {
            int cur = findNext1(flowerbed, index);
            if (index == -1 && cur == flowerbed.length) {
                sum += (flowerbed.length + 1) / 2;
                break;
            }
            if (index == -1 || cur == flowerbed.length) {
                sum += (cur - index - 1) / 2;
            } else {
                sum += (cur - index - 2) / 2;
            }
            System.out.println(cur + " " + sum);
            index = cur;
            if (index == flowerbed.length) {
                break;
            }
        }
        return n <= sum;
    }

    private int findNext1(int[] flowerbed, int cur) {
        for (int i = cur + 1; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                return i;
            }
        }
        return flowerbed.length;
    }

    public static void main(String[] args) {
        Code605 code = new Code605();
        System.out.println(code.canPlaceFlowers(new int[]{0, 0}, 2));
    }
}
