package org.mc.utils;

import java.util.Iterator;
import java.util.LinkedList;

public class AddTwoNumbers {
    public LinkedList<Integer> solve(LinkedList<Integer> first, LinkedList<Integer> second) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;

        Iterator<Integer> firstIt = first.iterator();
        Iterator<Integer> secondIt = second.iterator();

        while (firstIt.hasNext() || secondIt.hasNext()) {
            int firstDigit = firstIt.hasNext() ? firstIt.next() : 0;
            int secondDigit = secondIt.hasNext() ? secondIt.next() : 0;

            int partialSum = firstDigit + secondDigit + carry;

            result.addLast(partialSum % 10);
            carry = partialSum / 10;
        }

        if (carry > 0)
            result.addLast(carry);

        return result;
    }
}
