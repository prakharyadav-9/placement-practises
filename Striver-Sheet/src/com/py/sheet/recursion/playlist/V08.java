package com.py.sheet.recursion.playlist;

import java.util.*;

public class V08 {
    /*
     * return the subsequence sum to target
     * Note:: you can pick any element any number of times
     */

    static 
    public void sumToK(int arr[],int k ){
        Stack<Integer> picked= new Stack<>();
        Arrays.sort(arr);
        f(0, arr, k, picked);
    } 

    static void f(int idx,int arr[], int target, Stack<Integer> picked){
        if(target==0){
            System.out.println(picked);
            return;
        }
        if(arr[idx]<=target) // for current value at idx is greater than targ
        {
            picked.push(arr[idx]);
            f(idx, arr, target-arr[idx], picked); // picking idx
            picked.pop();
        }
        if(idx+1<arr.length){ // called only if further idx is possible
            f(idx+1, arr, target, picked); // not picking
        }
        
    }


    public static void main(String ...args){
        int arr[] ={6,5,7,1,8,2,9,9,7,7,9};//{7,2,6,5};//{2,7,3,6,};// 
        int target=6;//16;//7;//
        sumToK(arr, target);

    }
}
