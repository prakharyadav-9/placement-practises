package com.py.binarySearch.questions;

public class R01_LowerBound {
    
    /*
     * Link: https://www.codingninjas.com/studio/problems/lower-bound_8165382 
     */
    public static void main(String aargs[]){
        int arr[] = {1,2,2,3,3,5,10};
        int x=0;
        int idx = lowerBound(arr, arr.length, x);
        System.out.println(idx);
    }
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int idx=n; // even if we dont find an element we will have an ans
        int l=0, h=n-1; // our bounded search space
        while(l<=h){
            int mid = l+(h-l)/2;
            // System.out.println(l+ " "+mid+" "+h); // input indices
            if(arr[mid]<x){
                l=mid+1; // ans does not exist here and in lower half jump to higher half
            }else{
                // this accounts for arr[mid]>= x
                idx=mid; // could be our potential solution
                h=mid-1; // lets shrink our search space to lower half and find an answer
            }
            // System.out.println("-> "+l+ " "+mid+" "+h); // exit endices
        }
        return idx;
    }
}
