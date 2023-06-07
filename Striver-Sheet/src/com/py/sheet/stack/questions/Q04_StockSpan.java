package com.py.sheet.stack.questions;

import java.util.*;
public class Q04_StockSpan {
    
    public static
    void main(String []args){
        int arr[]  = {100, 80, 60, 70, 60, 75, 85,};
        System.out.printf("Original -> %s \n",Arrays.toString(arr));
        int stockSpan[] = calculateSpan(arr,arr.length);
        System.out.printf("stock spans :: -> %s",Arrays.toString(stockSpan));
        System.out.println();
    }
    public static 
    int[] calculateSpan(int price[], int n){
        // Your code here
        int res[] = new  int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() &&( price[st.peek()] <= price[i%n]))   st.pop();
            res[i%n] = st.isEmpty()? -1: st.peek();
            st.push(i%n);
        }
        // above we have found the neartestLeftGreatest as in indecies 
        // we need to count difference within the days 
        for(int i=0;i<n;i++){
            res[i%n] = i - res[i%n];
        }
        return res;
    }
}
