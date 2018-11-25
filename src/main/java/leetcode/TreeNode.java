package leetcode;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{val=" + val + "}";
    }

    public static TreeNode EXAMPLE = new TreeNode(1);
    static {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        EXAMPLE.left = left;
        EXAMPLE.right = right;
    }
}
