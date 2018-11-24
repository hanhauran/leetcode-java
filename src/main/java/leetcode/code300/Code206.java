package leetcode.code300;

import leetcode.ListNode;

/**
 * @author ihhr
 * @date 2018/11/24
 */

public class Code206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode right = cur.next;
        ListNode left = null;
        while (cur.next != null) {
            cur.next = left;
            left = cur;
            cur = right;
            right = right.next;
        }
        cur.next = left;
        return cur;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }

    public static void main(String[] args) {
        Code206 code = new Code206();
        System.out.println(code.reverseList(ListNode.EXAMPLE));
    }
}
