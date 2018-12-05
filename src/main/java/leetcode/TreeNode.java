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

    public void print2() {
        print2(this);
    }

    public static void print2(TreeNode node) {
        if (node.left != null) {
            print2(node.left);
        }
        System.out.print(node.val + " ");
        if (node.right != null) {
            print2(node.right);
        }
    }

    @Override
    public String toString() {
        return "TreeNode{val=" + val + "}";
    }

    public static TreeNode EXAMPLE = new TreeNode(2);
    static {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        EXAMPLE.left = left;
        EXAMPLE.right = right;
        left = new TreeNode(0);
        EXAMPLE.left.left = left;
    }
}
