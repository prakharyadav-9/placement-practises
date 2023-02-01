package com.py.sheet.binarysearch.easy;

public class Q05_CountOccurance {

	/*
	 * Given a sorted array Arr of size N and a number X,
	 *  you need to find the number of occurrences of X in Arr.
	 */
	static int count(int arr[], int n, int x) {
	    // code here
		int fo=-1, lo=-2;
		int l=0, h=n-1;
		while(l<=h) {
			int mid=(l+h)/2;
			if(arr[mid]==x) {
				h=mid-1;
				fo=mid;
			}
			else if(arr[mid]<x) {
				l=mid+1;
			}
			else {
				h=mid-1;
			}
		}
		l=0; h=n-1;
		while(l<=h) {
			int mid=(l+h)/2;
			if(arr[mid]==x) {
				lo=mid;
				l=mid+1;
			}else if(arr[mid]>x) {
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
		return lo-fo+1;
	}
	
	public static void main(String[] args) {
		int arr[]= {1, 1, 2, 2, 2, 2, 3}; 
		int x=2;
		System.out.println(count(arr,arr.length,x));
	}

}
