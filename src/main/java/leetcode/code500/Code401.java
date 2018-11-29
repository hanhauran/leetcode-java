package leetcode.code500;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hr.han
 * @date 2018/11/29 10:52
 */

public class Code401 {

    private boolean[] hours = new boolean[4];
    private boolean[] minutes = new boolean[6];

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            if (i <= 4 && (num - i) <= 6) {
                res.addAll(part(i, num - i));
            }
        }
        return res;
    }

    private List<String> part(int h, int m) {
        return fusion(getAll(h, hours), getAll(m, minutes));
    }

    private List<String> getAll(int i, boolean[] array) {
        reset(array);
        for (int index = 0; index < i; index++) {
            array[index] = true;
        }
        List<String> list = new ArrayList<>();
        while (true) {
            int flag = validate(array);
            if (flag == -1) {
                break;
            }

            list.add(getRes(array));
            rotate(array, flag);
        }
        list.add(getRes(array));
        return list;
    }

    private void rotate(boolean[] array, int index) {
        array[index] = false;
        array[index + 1] = true;

        if (! array[0]) {
            int left = 0, right = index - 1;
            while (left < right) {
                if (! array[right]) {
                    right--;
                } else if (array[left]) {
                    left++;
                } else {
                    array[left] = true;
                    array[right] = false;
                    left++;
                    right--;
                }
            }
        }
    }

    private int validate(boolean[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] && !array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private String getRes(boolean[] array) {
        StringBuilder sb = new StringBuilder();
        for (boolean b : array) {
            sb.append(b ? '1' : '0');
        }
        return sb.toString();
    }

    private List<String> fusion(List<String> left, List<String> right) {
        if (left.isEmpty()) {
            return right;
        }

        if (right.isEmpty()) {
            return left;
        }

        List<String> res = new ArrayList<>();
        for (String s1 : left) {
            for (String s2 : right) {
                int leftInt = Integer.parseInt(s1, 2);
                int rightInt = Integer.parseInt(s2, 2);
                if (leftInt < 12 && leftInt >= 0 && rightInt < 60 && rightInt >= 0) {
                    res.add(leftInt + ":" + String.format("%02d", rightInt));
                }
            }
        }
        return res;
    }

    private void reset(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = false;
        }
    }

    public static void main(String[] args) {
        Code401 code = new Code401();
        List<String> list = code.readBinaryWatch(2);
        list.sort(Comparator.comparingDouble(item -> {
            String tmp = item.replace(':', '.');
            return Double.parseDouble(tmp);
        }));
        System.out.println(list);
        System.out.println("[\"0:03\",\"0:05\",\"0:06\",\"0:09\",\"0:10\",\"0:12\",\"0:17\",\"0:18\",\"0:20\",\"0:24\",\"0:33\",\"0:34\",\"0:36\",\"0:40\",\"0:48\",\"1:01\",\"1:02\",\"1:04\",\"1:08\",\"1:16\",\"1:32\",\"2:01\",\"2:02\",\"2:04\",\"2:08\",\"2:16\",\"2:32\",\"3:00\",\"4:01\",\"4:02\",\"4:04\",\"4:08\",\"4:16\",\"4:32\",\"5:00\",\"6:00\",\"8:01\",\"8:02\",\"8:04\",\"8:08\",\"8:16\",\"8:32\",\"9:00\",\"10:00\"]".replace("\"", ""));
    }
}
