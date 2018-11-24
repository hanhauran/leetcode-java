package leetcode.code300;

import leetcode.ListNode;

/**
 * @author ihhr
 * @date 2018/11/24
 */

public class Code203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode add1 = new ListNode(0);
        add1.next = head;

        ListNode cur = head;
        ListNode left = add1;

        while (cur != null) {
            if (cur.val == val) {
                left.next = cur.next;
            } else {
                left = left.next;
            }
            cur = cur.next;
        }

        return add1.next;
    }

    public static void main(String[] args) {
        Code203 code = new Code203();
        System.out.println(code.removeElements(ListNode.EXAMPLE, 2));
    }
}
