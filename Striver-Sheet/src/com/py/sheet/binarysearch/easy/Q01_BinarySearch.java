package com.py.sheet.binarysearch.easy;

public class Q01_BinarySearch {

	static int binarySearchRec(int arr[], int l,int r, int k ) {
		int mid = (l+r)/2;
		if(l<=r && l<=arr.length-1) {
			if(arr[mid]==k) {
				return mid;
			}
			else if(arr[mid]>k) {
				return binarySearchRec(arr, l, mid-1, k);
			}
			else {
				return binarySearchRec(arr, mid+1, r, k);
			}
		}
		return -1;
	}
	static int binarysearch(int arr[], int n, int k) {
        // code here
		int idx=-1;
		int l=0;
		int r=n-1;
		while(l<=r) {
			int mid =(l+r)/2;
			if(arr[mid]==k) {
				return mid;
			}
			else if(arr[mid]> k) {
				r=mid-1;
			}else {
				l=mid+1;
			}
		}
		return idx;
    }
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7,8,9};
		int k=7;
		System.out.println(binarysearch(arr, arr.length, k));
		System.out.println(binarySearchRec(arr, 0, arr.length, k));
	}

}
