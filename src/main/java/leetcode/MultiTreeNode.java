package leetcode;

import java.util.List;

/**
 * @author hr.han
 * @date 2018/11/30 20:28
 */

public class MultiTreeNode {
    public int val;
    public List children;

    public MultiTreeNode() {}

    public MultiTreeNode(int val, List children) {
        this.val = val;
        this.children = children;
    }
}
