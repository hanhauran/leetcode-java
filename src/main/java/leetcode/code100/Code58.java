package leetcode.code100;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code58 {
    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        String[] array = s.split(" ");
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != null && !array[i].isEmpty()) {
                return array[i].length();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Code58 code = new Code58();
        System.out.println(code.lengthOfLastWord("Hello world"));
    }
}
