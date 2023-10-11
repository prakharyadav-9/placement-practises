package com.py.binarySearch.questions;

public class R07_SerachInRotetedSortedArray {
    
    /*
     * Link : 
     *  https://leetcode.com/problems/search-in-rotated-sorted-array/ 
     */
    public static void main(String args[]){
        int arr[] = {4,5,6,7,0,1,2};
        int t= 6;
        R07_SerachInRotetedSortedArray obj = new R07_SerachInRotetedSortedArray();
        int idxEle = obj.search(arr, t);
        System.out.println(idxEle);
    }
    public int search(int[] arr, int t) {
        int l=0,h=arr.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(t==arr[mid]) return mid;
            // identify the sorted part   
            if(arr[l]<=arr[mid]){
                // left half is sorted
                if(arr[l]<=t&&t<arr[mid]) h=mid-1; // value in sorted part
                else l=mid+1; // value not in sorted part
            }else {
                // right sorted
                if(arr[mid]<t && t<=arr[h]) l=mid+1; // value in sorted part
                else h=mid-1; // value not in sorted part
            } 
        }
        return -1; // search key t not found
    }
}
