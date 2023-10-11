package com.py.binarySearch.questions;

import java.util.Arrays;

public class R05_FirstAndLastOccOfElement {
    /*
     * LInk  : 
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/ 
     * 
     */
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1,-1};
        ans[0] = getFirstOcc(nums,target); // is just like ceil
        if(ans[0]!=-1){
            ans[1] = getLastOcc(nums,target); // is just like floor
        }
        return ans;
    }
    private int getLastOcc(int arr[],int t){
        int lO=-1;
        int l=0, h=arr.length-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]<=t){
                if(arr[mid]==t) lO=mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return lO;
    }
    private int getFirstOcc(int arr[],int t){
        int fO= -1; // initalized with default case
        int l=0,h = arr.length-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]>=t){
                h=mid-1;
                if(arr[mid]==t)
                    fO=mid;
            }else{
                l=mid+1;
            }
        }
        return fO;
    }

    public static void main(String []args){
        int arr[] = {5,7,7,8,8,10};
        int t = 8;
        R05_FirstAndLastOccOfElement obj = new R05_FirstAndLastOccOfElement();
        int res [] = obj.searchRange(arr, t);
        System.out.println(Arrays.toString(res));
    }
}
