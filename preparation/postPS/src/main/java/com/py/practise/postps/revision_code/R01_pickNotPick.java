package com.py.practise.postps.revision_code;

import java.util.*;

public class R01_pickNotPick {
    public static void main(String args[]) {
        List<String> strL = Arrays.asList("1", "2");
        System.out.println("printing all subsequence");
        generateAllSubsequence(strL);
    }

    private static void generateAllSubsequence(List<String> strL) {
        // print(strL, new Stack<String>(), 0);
        print_1(strL, new Stack<String>(), 0);

    }

    private static void print_1(List<String> strL, Stack<String> stack, int i) {
        if (i >= strL.size()) {
            System.out.println(stack);
        } else {
            // not pick
            print_1(strL, stack, 1 + i);
            stack.push(strL.get(i)); // consider this element
            print_1(strL, stack, 1 + i);
            stack.pop(); // removing the current value
        }
    }

    private static void print(List<String> strL, Stack<String> st, int i) {
        if (i + 1 <= strL.size()) {
            // not take
            print(strL, st, 1 + i);
            // take
            st.push(strL.get(i));
            // System.out.println(st);
            print(strL, st, 1 + i);
            st.pop();
        } else { // this case is arrising only when i crosses size of list
            System.out.println(st);
        }
    }
}
