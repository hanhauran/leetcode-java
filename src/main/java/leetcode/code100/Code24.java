package leetcode.code100;

import finder.annotation.*;
import leetcode.ListNode;

/**
 * @author hr.han
 * @date 2019/1/6 21:03
 */

@Level(Levels.MEDIUM)
@Method({Methods.LINKED_LIST, Methods.RECURSE})
@Question("给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。")
public class Code24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = head.next;
        ListNode left = swapPairs(head.next.next);
        root.next = head;
        head.next = left;

        return root;
    }
}

