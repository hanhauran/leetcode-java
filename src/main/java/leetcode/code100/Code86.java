package leetcode.code100;

import finder.annotation.*;
import leetcode.ListNode;

/**
 * @author hr.han
 * @date 2019/1/20 13:25
 */

@Level(Levels.MEDIUM)
@Question(
        value = "给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前，保留相对位置",
        input = "1->4->3->2->5->2  x=3",
        output = "1->2->2->4->3->5"
)
@Method(Methods.LINKED_LIST)
public class Code86 {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(x);
        ListNode cl = left;
        ListNode right = new ListNode(x);
        ListNode rl = right;

        while (head != null) {
            if (head.val < x) {
                cl.next = new ListNode(head.val);
                cl = cl.next;
            } else {
                rl.next = new ListNode(head.val);
                rl = rl.next;
            }
            head = head.next;
        }

        left = left.next;
        if (left == null) {
            return right.next;
        } else {
            cl.next = right.next;
            return left;
        }
    }
}
