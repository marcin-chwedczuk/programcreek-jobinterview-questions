package org.mc.utils;

import java.util.Stack;

public class MajorityElement {
    // array MUST contain majority element
    public int solve(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for(int i : array) {
            if (stack.empty()) {
                stack.push(i);
            }
            else if (stack.peek() != i) {
                // discard both elements
                stack.pop();
            }
            else {
                stack.push(i);
            }
        }

        if (stack.empty())
            throw new RuntimeException("no majority element");

        return stack.peek();
    }
}
