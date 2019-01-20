package leetcode.code100;

import finder.annotation.*;
import leetcode.ListNode;

/**
 * @author hr.han
 * @date 2019/1/20 12:23
 */

@Level(Levels.MEDIUM)
@Question("给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。")
@Method(Methods.LINKED_LIST)
public class Code82 {
    private ListNode previous;
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        previous = null;

        ListNode cur = head;
        ListNode res = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null) {
                    if (cur.val == cur.next.val) {
                        cur = cur.next;
                    } else {
                        break;
                    }
                }
                if (previous != null) {
                    previous.next = cur.next;
                    cur = cur.next;
                } else {
                    cur = cur.next;
                    res = cur;
                }
                if (cur == null) {
                    break;
                }
            } else {
                previous = cur;
                cur = cur.next;
            }
        }

        return res;
    }
}
