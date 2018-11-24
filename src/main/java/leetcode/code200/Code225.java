package leetcode.code200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ihhr
 * @date 2018/11/24
 */

class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        move22();
        q1.add(x);
        move21();
    }

    private void move21() {
        while (! q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    private void move22() {
        while (! q1.isEmpty()) {
            q2.add(q1.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

public class Code225 {

}
