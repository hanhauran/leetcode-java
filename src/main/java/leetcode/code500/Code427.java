package leetcode.code500;

import leetcode.QuadTreeNode;

/**
 * @author hr.han
 * @date 2018/11/30 20:02
 */

public class Code427 {

    static class Node extends QuadTreeNode {
        public Node() {
            super();
        }

        public Node(boolean val, boolean isLeaf, QuadTreeNode topLeft, QuadTreeNode topRight, QuadTreeNode bottomLeft, QuadTreeNode bottomRight) {
            super(val, isLeaf, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    public Node construct(int[][] grid) {
        return part(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node part(int[][] grid, int xStart, int xEnd, int yStart, int yEnd) {
        int flag = isSame(grid, xStart, xEnd, yStart, yEnd);
        if (flag != -1) {
            return new Node(flag == 1, true, null, null, null, null);
        } else {
            Node cur = new Node(false, false, null, null, null, null);
            if (xStart == xEnd && yStart == yEnd) {
                cur.topLeft = new Node(grid[xStart][yStart] == 1, true, null, null, null, null);
                cur.topRight = new Node(grid[xStart][yStart] == 1, true, null, null, null, null);
                cur.bottomLeft = new Node(grid[xStart][yStart] == 1, true, null, null, null, null);
                cur.bottomRight = new Node(grid[xStart][yStart] == 1, true, null, null, null, null);
            } else {
                cur.topLeft = part(grid, xStart, xStart + (xEnd - xStart) / 2, yStart, yStart + (yEnd - yStart) / 2);
                cur.topRight = part(grid, xStart, xStart + (xEnd - xStart) / 2, yEnd - (yEnd - yStart) / 2, yEnd);
                cur.bottomLeft = part(grid, xEnd - (xEnd - xStart) / 2, xEnd, yStart, yStart + (yEnd - yStart) / 2);
                cur.bottomRight = part(grid, xEnd - (xEnd - xStart) / 2, xEnd, yEnd - (yEnd - yStart) / 2, yEnd);;
            }
            return cur;
        }
    }

    private int isSame(int[][] grid, int xStart, int xEnd, int yStart, int yEnd) {
        // xStart <= xEnd && yStart <= yEnd
        int flag = grid[xStart][yStart];
        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                if (grid[i][j] != flag) {
                    return -1;
                }
            }
        }
        return flag;
    }

}
