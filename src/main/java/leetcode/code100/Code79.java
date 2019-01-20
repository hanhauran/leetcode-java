package leetcode.code100;

import finder.annotation.*;

/**
 * @author hr.han
 * @date 2019/1/19 21:20
 */

@Level(Levels.MEDIUM)
@Question("给定一个二维网格和一个单词，找出该单词是否存在于网格(相邻网格)中。")
@Method(Methods.BFS)
@Unsolved
public class Code79 {
    @Wrong
    public boolean exist(char[][] board, String word) {
        return recurse(board, word, new StringBuilder(word).reverse().toString(), new StringBuilder(), 0, 0);
    }

    @Wrong
    private boolean recurse(char[][] board, String word, String reverse, StringBuilder builder, int x, int y) {
        System.out.println(builder.toString());
        if (builder.length() == word.length()) {
            String cur = builder.toString();
            return word.equals(cur) || reverse.equals(cur);
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            builder.append(' ');
            return false;
        }

        builder.append(board[x][y]);
        boolean flag1 = recurse(board, word, reverse, builder, x - 1, y);
        builder.deleteCharAt(builder.length() - 1);
        boolean flag2 = recurse(board, word, reverse, builder, x, y + 1);
        builder.deleteCharAt(builder.length() - 1);
        boolean flag3 = recurse(board, word, reverse, builder, x + 1, y);
        builder.deleteCharAt(builder.length() - 1);
        return flag1 | flag2 | flag3;
    }

    public static void main(String[] args) {
        Code79 code = new Code79();
        char[][] chars = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        System.out.println(code.exist(chars, "ASF"));
    }
}
