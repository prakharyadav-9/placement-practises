package com.py.sheet.sorting;

public class Q02_CheckSorted {

	/*
	 * Given an array arr[] of size N, check if it is sorted in non-decreasing order or not. 
	 */
	static boolean  arraySortedOrNot(int arr[]) {
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[i-1]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int array[] = {1,2,3,4};//{10,7,6,5,3,9,2,1,8,4};
		System.out.println(arraySortedOrNot(array));
	}

}
