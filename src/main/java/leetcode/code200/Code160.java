package leetcode.code200;

import leetcode.ListNode;

/**
 * @author ihhr
 * @date 2018/11/7
 */

public class Code160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = length(headA);
        int lenB = length(headB);

        if (lenA > lenB) {
            headA = move(headA, lenA - lenB);
        } else if (lenA < lenB) {
            headB = move(headB, lenB - lenA);
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private ListNode move(ListNode cur, int len) {
        while (cur != null && len > 0) {
            cur = cur.next;
            len--;
        }
        return cur;
    }

    private int length(ListNode node) {
        int len = 0;

        if (node == null) {
            return len;
        }

        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static void main(String[] args) {
        Code160 code = new Code160();

        ListNode headA = new ListNode(3);
        ListNode headB = new ListNode(2);
        headB.next = headA;

        System.out.println(code.getIntersectionNode(headA, headB));
    }
}
