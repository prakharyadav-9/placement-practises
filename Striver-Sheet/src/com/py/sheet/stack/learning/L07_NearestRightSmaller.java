package com.py.sheet.stack.learning;

import java.util.*;

public class L07_NearestRightSmaller {
    
    public static void main(String...args){
        int arr[] = {4,5,2,10,8,}; 
                // {1,4,2,3,6,4};
        boolean  isCircular  =false;
        int ans[] =  nextSmallerRightElement(arr,isCircular);
        System.out.printf("Original -> %s \n ans  => %s", Arrays.toString(arr), Arrays.toString(ans));
        System.out.println();
    }

    private static int[] nextSmallerRightElement(int[] arr, boolean isCircular) {
        int N= arr.length;
        int res [] = new int[N];
        int stpCnd = N*(isCircular?2:1) -1;
        Stack<Integer> st = new Stack<>();
        System.out.println(stpCnd);
        for(int i=stpCnd; i>=0;i--){
            while(st.isEmpty() == false
                    && (arr[st.peek()] >= arr[i%N]) ) st.pop(); // popping till top is greater
            res[i%N] = st.isEmpty()? -1: arr[st.peek()];
            st.push(i%N);
        }
        return res;
    }
}
