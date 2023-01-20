package com.py.sheet.knowBasicMath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountFrequency {

	/*
	 * Given an array A[] of N positive integers which can contain integers from 1 to P 
	 * where elements can be repeated or can be absent from the array. 
	 * Your task is to count the frequency of all elements from 1 to N.
	 * Note: The elements greater than N in the array can be ignored for counting and do modify the array in-place.
	 */
	
	public static void frequencyCount(int arr[], int N, int P)
    {
        Map<Integer, Integer> map = new HashMap<>(P);
        for(int ele: arr) {
        	if(ele<=N) {
        		map.putIfAbsent(ele,0);
        		map.put(ele, map.get(ele)+1);
//        		if(map.containsKey(ele)) {
//        			map.put(ele, map.get(ele)+1);
//        		}else
//        			map.put(ele,1);
        	}
        	
        }
        map.remove(2,null);
        for(int i=0;i<arr.length;i++) {
        	arr[i]= map.getOrDefault(i+1, 0);
        }
    }
	public static void fc(int arr[], int N, int P) {
		for(int i=0;i<N;i++) {
			arr[i]-=1;
		}
		for(int i=0;i<N;i++) {
			int idx= arr[i]%N;
			arr[idx] +=N;
			
		}
		for(int i=0;i<N;i++) {
			arr[i]/=N;
		}
	}
	public static void main(String[] args) {
		int arr[] ={3,3,3,3};// {2, 3, 2, 3, 5};
		int P= 5;
//		frequencyCount(arr, arr.length, P);
		fc(arr, arr.length,P);
		System.out.println(Arrays.toString(arr));

	}

}
