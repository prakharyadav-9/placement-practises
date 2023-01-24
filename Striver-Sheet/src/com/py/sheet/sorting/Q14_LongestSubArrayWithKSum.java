package com.py.sheet.sorting;

import java.util.HashMap;

public class Q14_LongestSubArrayWithKSum {

	public static int lenOfLongSubarr (int arr[], int N, int K) {
		// map stores the sum uptill this index (value)
		HashMap<Integer,Integer> map = new HashMap<>();
		// initial sum is 0
		map.put(0,-1);
        int len=0;
        int totalSum=0;
        for(int i=0;i<N; i++){
        	totalSum+=arr[i]; // taking the uptill sum
            int diff = totalSum-K; // calculating the difference how far we have reached
            if(map.containsKey(diff)){ 
            	/*
            	 * if already have the difference then change the starting window idx and get the length
            	 */
                int currentLen = i-map.get(diff);
                len = Math.max(len,currentLen);
            }
            if(map.containsKey(totalSum) == false){
                map.put(totalSum,i);
            }
        }
        return len;
		
        //create a hashmap to store sum and their index
//        HashMap<Integer,Integer> map = new HashMap<>();
//        //initially sum is 0 at index =-1
//        map.put(0,-1);
//        int s1 =0;
//        int len = 0;
//        for(int i =0;i<N;i++){
//            //find the s1
//            s1+=A[i];
//            //find the s2
//            int s2 = s1-K;
//            //check s2 is present or not
//            if(map.containsKey(s2)){
//                //find the max length
//                int plen = i-map.get(s2);
//                len = Math.max(len,plen);
//            }
//            //if s1 is not present,put in hashmap 
//            if(map.containsKey(s1)==false)
//            {
//                map.put(s1,i);
//            }
//        }
//        return len;
    }
	
	public static void main(String[] args) {
		int arr[]={-13,-9,16,10,19,15,5,17,10, 5,6};// {10, 5, 2, 7, 1, 9,1,1,1,1,2,1};
		int k=4;
		System.out.println(lenOfLongSubarr(arr, arr.length, k));

	}

}
