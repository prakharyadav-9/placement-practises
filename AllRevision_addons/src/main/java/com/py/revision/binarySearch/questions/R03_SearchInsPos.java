package com.py.revision.binarySearch.questions;

public class R03_SearchInsPos {

    /*
     * Link: https://leetcode.com/problems/search-insert-position/ 
     */
    public int searchInsert(int[] nums, int target) {
        int l=0, h = nums.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]==target) return mid; // found our element
            else if(nums[mid]>target) h=mid-1; // shrink to lower half
            else l=mid+1; // shrink to higher half
        }
        return l;
    }
    public static void main(String args[]){
        int arr[] = {1,3,5,6};
        int x = 5;
        R03_SearchInsPos obj = new R03_SearchInsPos();
        int idx = obj.searchInsert(arr, x);
        System.out.println(idx);
    }
}
