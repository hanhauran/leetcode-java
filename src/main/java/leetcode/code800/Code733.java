package leetcode.code800;

/**
 * @author hr.han
 * @date 2018/12/22 12:45
 */

public class Code733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc]) {
            return image;
        }

        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int oc, int nc) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oc) {
            return;
        }

        image[sr][sc] = nc;
        helper(image, sr - 1, sc, oc, nc);
        helper(image, sr, sc - 1, oc, nc);
        helper(image, sr + 1, sc, oc, nc);
        helper(image, sr, sc + 1, oc, nc);
    }
}
