package leetcode.code100;

import finder.annotation.*;
import leetcode.ListNode;

/**
 * @author hr.han
 * @date 2019/1/16 22:22
 */

@Level(Levels.MEDIUM)
@Question("旋转链表，使得每个节点右移 k 个位置")
@Method(Methods.LINKED_LIST)
public class Code61 {
    private ListNode tail;

    public ListNode rotateRight(ListNode head, int k) {
        tail = null;

        int len = len(head);
        if (len <= 1) {
            return head;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }

        k = len - k;

        ListNode cur = head;
        while (k != 1) {
            cur = cur.next;
            k--;
        }

        ListNode res = cur.next;
        cur.next = null;
        tail.next = head;
        return res;
    }

    private int len(ListNode node) {
        int res = 0;
        while (node != null) {
            tail = node;
            node = node.next;
            res++;
        }
        return res;
    }
}
