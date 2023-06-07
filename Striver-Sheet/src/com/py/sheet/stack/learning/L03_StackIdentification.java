package com.py.sheet.stack.learning;

import java.util.*;
public class L03_StackIdentification {
    
    public static void main(String...args){
        System.out.println("we will identify the problems to us a datastructure.");
        /*
         * when ever we have a dependent loop iterations 
         *      - for( i=0 -> n)
         *          for( j= i+/- x -> n/0)
         *  that is:: 
         *      1. 0 -> i
         *      2. i -> 0
         *      3. i -> n
         *      4. n -> i
         * then we can definitely use stack to reduce the complexity to O(n)
         */
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(9);
        System.out.printf(" %s \n",st.toString());
        System.out.printf("popped = %d \n",st.pop());
        System.out.printf(" peek  = %d \n",st.peek());
        System.out.printf("pver all stack = %s \n", st.toString());
    }
}
