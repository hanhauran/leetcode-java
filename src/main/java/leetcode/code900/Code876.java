package leetcode.code900;

import finder.annotation.Level;
import finder.annotation.Levels;
import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hr.han
 * @date 2019/1/3 11:26
 */

@Level(Levels.EASY)
public class Code876 {
    public ListNode middleNode(ListNode head) {
        List<ListNode> list = list(head);
        return list.get(list.size() / 2);
    }

    private List<ListNode> list(ListNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        List<ListNode> result = new ArrayList<>();
        while (node != null) {
            result.add(node);
            node = node.next;
        }
        return result;
    }
}
