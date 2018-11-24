package leetcode.code300;

import java.util.Stack;

/**
 * @author ihhr
 * @date 2018/11/24
 */

class MyQueue {

    private Stack<Integer> q1;
    private Stack<Integer> q2;

    /** Initialize your data structure here. */
    public MyQueue() {
        q1 = new Stack<>();
        q2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        q1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (q2.isEmpty()) {
            move22();
        }

        return q2.pop();
    }

    private void move22() {
        while (! q1.isEmpty()) {
            q2.push(q1.pop());
        }
    }

    /** Get the front element. */
    public int peek() {
        if (q2.isEmpty()) {
            move22();
        }

        return q2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

public class Code232 {
}
