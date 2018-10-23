package leetcode;

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode tmp = this;
        while (tmp != null) {
            builder.append(tmp.val).append(",");
            tmp = tmp.next;
        }
        return builder.substring(0, builder.length() - 1).toString();
    }
}
