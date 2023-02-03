package com.py.sheet.binarysearch.easy;

public class Q05_NumberOfOccurance {

	static int count(int[] arr, int n, int x) {
        // code here

		/*
		 * approach is find first idx and last idx 
		 * return count = last - first + 1
		 */
		int fo=-1, lo=-2;
		int l=0, h=n-1;
		while(l<=h) {
			int mid = (l+h)/2;
			if(arr[mid]==x) {
				fo=mid;
				h=mid-1;
			}else if ( arr[mid] > x) {
				h= mid-1;
			}
			else {
				l= mid+1;
			}
		}
		l=0;
		h=n-1;
		while(l<=h && fo!=-1 ) {
			int mid=(l+h)/2;
			if(arr[mid]==x) {
				lo=mid;
				l= mid+1;
			}else if( arr[mid]>x) {
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
		return (lo-fo +1);
    }

	public static void main(String[] args) {
		int arr[]={10,11};//{1, 1, 2, 2, 2, 2, 3};
		int x=100;
		System.out.println(count(arr,arr.length,x));

	}

}
