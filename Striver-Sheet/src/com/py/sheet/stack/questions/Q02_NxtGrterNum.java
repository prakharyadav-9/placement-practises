package com.py.sheet.stack.questions;

import java.util.*;

public class Q02_NxtGrterNum {
    
    public static void main(String...args){
        int N=5;
        boolean isCircular=true;
        int arr[] = 
            {10,20,9,1,0,};
            // new int[N];
        // random values filling
        // int min = 10;
        // int max = 71;
        // for(int i =0;i<arr.length;i++){
        //     arr[i] = (int) Math.floor(min +  (max-min+1)*Math.random());
        // }
        System.out.printf("Initial Array -> %s \n",Arrays.toString(arr));
        System.out.printf("Next greatere Number with circular DS = %b \n => %s", isCircular, Arrays.toString(nextGreaterElement(arr, isCircular)));
        System.out.println();
    }
    static int[] nextGreaterElement(int []arr, boolean isCircular){
        int N=arr.length;
        int ans[] = new int[arr.length];
        int circ = isCircular?1:0;
        int stopCondition = (1+circ)*N-1;
        // using a stack to do the operation
        Stack<Integer> stack = new Stack<>();
        for(int i=stopCondition; i>=0;i--){
            // pop out all lesser elements form stack
            while(!stack.isEmpty() && (stack.peek() <=arr[i%N])){
                stack.pop();
            }
            // since we might cover the wrape arround NGE so considering only for N elements
            if(i<N){    
                if(stack.isEmpty()){
                    ans[i%N] = -1;
                } else{
                    ans[i%N] = stack.peek();
                }
            }
            // simply adding elements to stack once corresponding NGE is decided
            // because it might happen current element is the NGE for some
            stack.push(arr[i%N]);
        }
        return ans;
    }
}
