package leetcode.code300;

import leetcode.ListNode;

/**
 * @author ihhr
 * @date 2018/11/25
 */

public class Code237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteNode2(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }

        node.val = node.next.val;
        node.next = null;
    }

    public static void main(String[] args) {
        Code237 code = new Code237();
        code.deleteNode(ListNode.EXAMPLE);
        System.out.println(ListNode.EXAMPLE);
    }
}
