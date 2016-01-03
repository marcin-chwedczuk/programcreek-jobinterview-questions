package org.mc.utils;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> _stack = new Stack<>();
    private Stack<Integer> _minStack = new Stack<>();

    public MinStack() {
        _minStack.push(Integer.MAX_VALUE);
    }

    public boolean isEmpty() {
        return _stack.isEmpty();
    }

    public void push(int element) {
        _stack.push(element);
        _minStack.push(Math.min(_minStack.peek(), element));
    }

    public int pop() {
        int value = _stack.pop();
        _minStack.pop();

        return value;
    }

    public int top() {
        return _stack.peek();
    }

    public int getMin() {
        return _minStack.peek();
    }
}
