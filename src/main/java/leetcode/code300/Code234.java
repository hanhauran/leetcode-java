package leetcode.code300;

import leetcode.ListNode;

import java.util.LinkedList;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        while (! list.isEmpty()) {
            if (list.size() == 1) {
                return true;
            }
            if (list.getFirst().equals(list.getLast())) {
                list.removeFirst();
                list.removeLast();
            } else {
                return false;
            }
        }

        return true;
    }
}
