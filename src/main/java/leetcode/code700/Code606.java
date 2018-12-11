package leetcode.code700;

import leetcode.TreeNode;

/**
 * @author hr.han
 * @date 2018/12/11 15:30
 */

public class Code606 {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        return part(t, true);
    }

    private String part(TreeNode t, boolean left) {
        if (t == null) {
            if (left) {
                return "()";
            } else {
                return "";
            }
        }

        String cur = String.valueOf(t.val);
        if (t.left != null) {
            cur += "(" + part(t.left, true) + ")";
        }
        if (t.right != null) {
            if (t.left == null) {
                cur += "()";
            }
            cur += "(" + part(t.right, false) + ")";
        }
        return cur;
    }

    public static void main(String[] args) {
        Code606 code = new Code606();
        System.out.println(code.tree2str(TreeNode.EXAMPLE));
    }
}
