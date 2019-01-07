package leetcode.code100;

import finder.annotation.Level;
import finder.annotation.Levels;

/**
 * @author hr.han
 * @date 2019/1/7 15:50
 */

@Level(Levels.MEDIUM)
public class Code36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (! validate1(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (! validate2(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                if (! validate3(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validate3(char[][] board, int xs, int ys) {
        int[] helper = new int[9];
        for (int i = xs; i < xs + 3; i++) {
            for (int j = ys; j < ys + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                helper[board[i][j] - '1']++;
                if (helper[board[i][j] - '1'] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validate2(char[][] board, int col) {
        int[] helper = new int[9];
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == '.') {
                continue;
            }
            helper[board[i][col] - '1']++;
            if (helper[board[i][col] - '1'] > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean validate1(char[][] board, int line) {
        int[] helper = new int[9];
        for (int i = 0; i < board[0].length; i++) {
            if (board[line][i] == '.') {
                continue;
            }
            helper[board[line][i] - '1']++;
            if (helper[board[line][i] - '1'] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char c = '0';
        System.out.println((int) c);
    }
}
