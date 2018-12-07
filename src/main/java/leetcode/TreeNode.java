package leetcode;

import java.util.List;

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

    public void print1() {
        print1(this);
    }

    public void print2() {
        print2(this);
    }

    public void print3() {
        print3(this);
    }

    public void list1(List<Integer> list) {
        list1(list, this);
    }

    public void list2(List<Integer> list) {
        list2(list, this);
    }

    public void list3(List<Integer> list) {
        list3(list, this);
    }

    public static void print1(TreeNode node) {
        System.out.println(node.val + " ");
        if (node.left != null) {
            print1(node.left);
        }
        if (node.right != null) {
            print1(node.right);
        }
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

    public static void print3(TreeNode node) {
        if (node.left != null) {
            print3(node.left);
        }
        if (node.right != null) {
            print3(node.right);
        }
        System.out.println(node.val + " ");
    }

    public static void list1(List<Integer> list, TreeNode node) {
        list.add(node.val);
        if (node.left != null) {
            list1(list, node.left);
        }
        if (node.right != null) {
            list1(list, node.right);
        }
    }

    public static void list2(List<Integer> list, TreeNode node) {
        if (node.left != null) {
            list2(list, node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            list2(list, node.right);
        }
    }

    public static void list3(List<Integer> list, TreeNode node) {
        if (node.left != null) {
            list3(list, node.left);
        }
        if (node.right != null) {
            list3(list, node.right);
        }
        list.add(node.val);
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
