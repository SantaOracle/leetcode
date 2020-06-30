package org.github.learning.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode-cn.com/problems/implement-stack-using-queues/"></a>
 * Status:  AC
 * Runtime: 0 ms, faster than 100%
 * @author jiangpeiheng create on 2020/6/30
 */
public class Title225 {

    static class MyStack {

        private Deque<Integer> queue = new ArrayDeque<>();
        private static final int INVALID_ELE = -1;

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            this.queue.push(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return empty() ? INVALID_ELE : this.queue.pop();
        }

        /** Get the top element. */
        public int top() {
            return empty() ? INVALID_ELE : this.queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
}
