package com.py.sheet.slidingwindow_twoPointer;

import java.util.*;
import com.py.util.Util;

public class Q06_LongestSubArrayOfSumK{
    /* Problem link: 
     * https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
     */
    public static void main(String...args){
        int arr[] = {-13 ,0 ,6 ,15, 16, 2 ,15 ,-12, 17, -16, 0 ,-3 ,19 ,-3, 2 ,-9, -6};//{1, 4, 3, 3, 5, 5};//{10, 5, 2, 7, 1, 9};
        int k=15;//16;//15;
        int length = lenOfLongSubarr(arr,arr.length,k);
        System.out.println(length);

    }
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        Map<Integer,Integer> map =new HashMap<>();
        // <sum,TillIdx>
        int currSum=0;
        int longestSubArray=0;
        for(int i=0;i<N;i++){
            currSum+=A[i];
            // if sum reaches K 
            if(currSum==K){
                longestSubArray=Math.max(longestSubArray,i+1);
                // could be possible from starting till i 
                // is summed to K therefore is a solution
            } 
            // put the unique sum till till the point in map
            if(!map.containsKey(currSum)){
                map.put(currSum,i);
            }
            // get remainder
            int rem=currSum-K;
            if(map.containsKey(rem)){
                // update longestSubArray
                longestSubArray=Math.max(longestSubArray,i-map.get(rem));
            }
        }
        return longestSubArray;
    }
    
}