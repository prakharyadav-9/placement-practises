package com.py.sheet.binarysearch.easy;

public class Q08_MinimumInRotatedSorted {

	/*
	 * FInd minimum in rotated sorted array
	 */
	static int findMin(int arr[], int n){
        //complete the function here
		int l=0;
		int h=n-1;
		while(l<h) {
			int mid = l+ (h-l)/2;
			if(arr[l]<=arr[mid] && arr[mid] <arr[h]) {
				h=mid-1;
			}else {
				l=mid+1;
			}
//			if(arr[mid]>arr[h]) {
//					l=mid+1;
//			}else {
//				h=mid;
//			}
		}
		return arr[h];
	}
	
	public static void main(String[] args) {
		int arr[]={1,2,3,4 ,5 ,6,7,8,9,};//{2,3,4,5,1};
		System.out.println(findMin(arr,arr.length));

	}

}
