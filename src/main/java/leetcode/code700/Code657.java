package leetcode.code700;

/**
 * @author hr.han
 * @date 2018/12/11 18:44
 */

public class Code657 {
    public boolean judgeCircle(String moves) {
        int[] helper = new int[4];
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L': helper[0]++; break;
                case 'R': helper[1]++; break;
                case 'U': helper[2]++; break;
                case 'D': helper[3]++; break;
                default:
            }
        }
        return helper[0] == helper[1] && helper[2] == helper[3];
    }
}
