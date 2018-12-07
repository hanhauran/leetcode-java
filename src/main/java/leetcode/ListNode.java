package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ihhr
 * @date 2018/10/23
 */

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public List<Integer> list() {
        return list(this);
    }

    public static List<Integer> list(ListNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<Integer> res = new ArrayList<>();
        while (node != null) {
            res.add(node.val);
            node = node.next;
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode tmp = this;
        while (tmp != null) {
            builder.append(tmp.val).append(",");
            tmp = tmp.next;
        }
        return builder.substring(0, builder.length() - 1);
    }

    public static final ListNode EXAMPLE;
    static {
        EXAMPLE = new ListNode(1);
        EXAMPLE.next = new ListNode(2);
        EXAMPLE.next.next = new ListNode(3);
    }
}
