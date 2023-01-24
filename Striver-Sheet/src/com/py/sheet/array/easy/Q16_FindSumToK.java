package com.py.sheet.array.easy;

import java.util.HashMap;
import java.util.Map;

public class Q16_FindSumToK {

	/*
	 * Given an array Arr of N positive integers and another number X. 
	 * Determine whether or not there exist two elements in Array whose sum is exactly X.
	 */
	static  boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
		// <difference, Idx>
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			int diff = x-arr[i];
			if(map.containsKey(arr[i])) {
				return true;
			}
			map.put(diff,i);
		}
		return false;
    }
	public static void main(String[] args) {

		int Arr[] = {1,2,5,6,7};//{1, 4, 45, 6, 10, 8};
		int x=4;
		System.out.println(hasArrayTwoCandidates(Arr, Arr.length, x));
		
	}

}
