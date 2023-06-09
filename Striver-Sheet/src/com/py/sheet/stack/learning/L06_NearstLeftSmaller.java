package com.py.sheet.stack.learning;

import java.util.*;

public class L06_NearstLeftSmaller {
    
    public static void main(String...args){
        int arr[] = {4,5,2,1,10,8,}; 
                // {1,4,2,3,6,4};
        boolean  isCircular  =false;
        int ans[] =  nextSmallerLeftElement(arr,isCircular);
        System.out.printf("Original -> %s \n ans  => %s", Arrays.toString(arr), Arrays.toString(ans));
        System.out.println();
    }

    private static 
    int[] nextSmallerLeftElement(int[] arr, boolean isCircular) {
        int N  = arr.length;
        int ans [] = new int[N];
        Stack<Integer> st = new Stack<>();
        int stpCnd = N*(isCircular?2:1) -1;
        for(int i=0; i<=stpCnd;i++){
            while(st.isEmpty() == false && ( arr[i%N] <= arr[st.peek()])) st.pop();
            ans[i%N] = st.isEmpty()? -1: arr[st.peek()];
            st.push(i%N);
        }
        return ans;
    }
}
