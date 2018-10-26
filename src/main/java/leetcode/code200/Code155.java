package leetcode.code200;

import java.util.Stack;

/**
 * @author ihhr
 * @date 2018/10/26
 */

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() > x) {
            min.push(x);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

public class Code155 {

}
