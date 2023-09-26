package com.py.binarySearch.questions;

public class R02_UpperBound {
    public static void main(String args[]){
        int arr[] = {1,4,7,8,10};//{1,2,5,6,10,};
        int x=7;
        int idx = upperBound(arr,x, arr.length);
        System.out.println(idx);
    }
    public static int upperBound(int []arr, int x, int n){
        // Write your code here.
        int idx=n; // default ans
        int l = 0, h = n-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            // System.out.println(l+" "+mid+" "+h);
            if(arr[mid]>x){ // check for only values greater than x
                idx=mid; // potential answer
                h=mid-1; // shrink to lower half 
            }else{
                // accounts for arr[mid]<=x
                l=mid+1; // shift to higher half
            }
            // System.out.println("->"+l+" "+mid+" "+h);
        }
        return idx;
    }
}
