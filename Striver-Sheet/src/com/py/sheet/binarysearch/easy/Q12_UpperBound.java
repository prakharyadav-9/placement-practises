package com.py.sheet.binarysearch.easy;

public class Q12_UpperBound {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,6,6,8};
		int k=4;
		System.out.println(findUpperBound(arr,k) );
	}

	private static int findUpperBound(int[] arr, int k) {
		int l=0;
		int h=arr.length;
		while(h>l) {
			int mid=(l+h)/2;
			if(arr[mid]<=k) {
				l=mid+1;
			}
			else if(arr[mid]>k) {
				h=mid;
			}
		}
		return l; // returns the index of the upper bound of the element
		/*
		 * else we could also say that the number returned is the number of elements that are 
		 * <= to the given number k
		 */
	}

}
