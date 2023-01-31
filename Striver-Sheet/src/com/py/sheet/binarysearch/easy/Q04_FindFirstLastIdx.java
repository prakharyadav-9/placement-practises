package com.py.sheet.binarysearch.easy;

import java.util.ArrayList;

public class Q04_FindFirstLastIdx {

	static ArrayList<Long> find(long arr[], int n, int x){
        // code here
		ArrayList<Long> result = new ArrayList<>();
		int l=0,h=n-1;
		int lo=-1,fo=-1;
		while(l<=h) {
			int mid= (l+h)/2;
			if(arr[mid]==x) {
				h=mid-1;
				fo=mid;
			}
			else if(arr[mid] >x ) {
				h=mid-1;
			}
			else {
				l=mid+1;
			}
		}
		l=0;
		h=n-1;
		while(l<=h && fo!=-1) {
			int mid=(l+h)/2;
			if(arr[mid]==x){
			  l= mid+1;  
			  lo=mid;
			}else
			if(arr[mid]<x) {
				l=mid+1;
			}
			else {
				h=mid-1;
			}
		}
		result.add((long)fo);
		result.add((long)lo);
		return result;
    
		
		/*
		 * 
		 * Below implementation will only work if there is numbers present 
		 * for x not in arr will result in infinite loop or TLE
		 */
//		ArrayList<Long> result = new ArrayList<>();
//		int l=0,h=n-1;
//		int mid0= (l+h)/2;
//		while(arr[l]!=x && l<n) {
//			int mid= (l+h)/2;
//			if(arr[mid]>=x) {
//				h=mid-1;
//			}
//			else {
//				l=mid+1;
//			}
//		}
//		result.add((long)l);
//		l=0;
//		h=n-1;
//		while(arr[h]!=x && h>0) {
//			int mid=(l+h)/2;
//			if(arr[mid]<=x) {
//				l=mid+1;
//			}
//			else {
//				h=mid-1;
//			}
//		}
//		result.add((long)h);
//		return result;
    }
	
	public static void main(String[] args) {
		long arr[] = { 1, 3, 5, 5, 5, 5,5, 67,123, 125 };
		int x=1;
		System.out.println(find(arr,arr.length,x));

	}

}
