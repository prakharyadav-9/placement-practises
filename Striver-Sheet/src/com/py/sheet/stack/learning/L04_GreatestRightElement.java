package com.py.sheet.stack.learning;

import java.util.*;
public class L04_GreatestRightElement {
    
    public static void main(String...args){
        int arr[] = {1,4,2,3,6,4};
        boolean  isCircular  =false ;
        int ans[] =  nextGreatestRightElement(arr,isCircular);
        System.out.printf("Original -> %s \n ans  => %s", Arrays.toString(arr), Arrays.toString(ans));
        System.out.println();
    }

    private static int[] nextGreatestRightElement(int[] arr, boolean isCircular) {
        // in this implementation we are going to store indicies of the element instead of actual elements in stack
        int N = arr.length;
        int res[] = new int[N];
        int stopCon = N*(1+(isCircular? 1:0))-1;
        Stack<Integer> st = new Stack<>();
        for(int i = stopCon ; i>= 0;i--){
            while(!st.isEmpty() && (arr[st.peek()] <= arr[i%N])){
                st.pop();
            }
            if(i<N){
                if(st.isEmpty()){
                    res[i%N]=-1;
                }
                else{
                    res[i%N] = arr[st.peek()];
                }   
            }
            st.push(i%N); // its here bcz if we consider circular DS it wont afftect the result
        }
        return res;
    }
}
