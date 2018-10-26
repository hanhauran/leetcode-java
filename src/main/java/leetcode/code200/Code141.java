package leetcode.code200;

import leetcode.ListNode;

/**
 * @author ihhr
 * @date 2018/10/26
 */

public class Code141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
