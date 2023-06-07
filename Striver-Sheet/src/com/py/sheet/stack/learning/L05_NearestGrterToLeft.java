package com.py.sheet.stack.learning;

import java.util.*;

public class L05_NearestGrterToLeft {
    
    public static void main(String...args){
        int arr[] = {1,3,2,4}; 
                // {1,4,2,3,6,4};
        boolean  isCircular  =true ;
        int ans[] =  nextGreatestLeftElement(arr,isCircular);
        System.out.printf("Original -> %s \n ans  => %s", Arrays.toString(arr), Arrays.toString(ans));
        System.out.println();
    }

    private static int[] nextGreatestLeftElement(int[] arr, boolean isCircular) {
        int N= arr.length;
        int res[] = new int[N];
        Stack<Integer> st =  new Stack<>();
        int stpCnd = N*((isCircular?1 : 0) + 1) - 1;
        System.out.println(stpCnd);
        for(int i=0 ; i<= stpCnd; i++){
            while(!st.isEmpty() && (arr[st.peek()]<= arr[i%N] )){
                st.pop();
            }
            // if(i>(N+1)/2)
            {
                if(st.isEmpty())    res [ i%N] = -1;
                else res[i%N] = arr[st.peek()];
            }
            st.push(i%N);
        }   
        return res;
    }
}
