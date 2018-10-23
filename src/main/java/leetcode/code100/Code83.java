package leetcode.code100;

import leetcode.ListNode;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class Code83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        int tmp = head.val;

        ListNode cur = new ListNode(tmp);
        ListNode curTmp = cur;
        ListNode root = head;
        while (root != null) {
            if (root.val == tmp) {
                root = root.next;
            } else {
                curTmp.next = new ListNode(root.val);
                tmp = root.val;
                curTmp = curTmp.next;
                root = root.next;
            }
        }

        return cur;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Code83 code = new Code83();
        ListNode node4 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(node1);
        System.out.println(code.deleteDuplicates2(node1));
    }
}
