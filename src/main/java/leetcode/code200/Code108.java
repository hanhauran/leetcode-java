package leetcode.code200;

import leetcode.TreeNode;

/**
 * @author ihhr
 * @date 2018/10/24
 */

public class Code108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }

        return part(nums, 0, nums.length - 1);
    }

    private TreeNode part(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = (left + right) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = part(nums, left, mid - 1);
        cur.right = part(nums, mid + 1, right);
        return cur;
    }
}
