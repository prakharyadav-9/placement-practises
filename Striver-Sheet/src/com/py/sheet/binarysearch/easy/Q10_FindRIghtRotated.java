package com.py.sheet.binarysearch.easy;

public class Q10_FindRIghtRotated {

	static int findKRotation(int arr[], int n) {
        // code here
		if(arr[0]<arr[n-1])
			return 0;
		int l=0;
		int h=n-1;
		while(l<h) {
			int mid = (l+h)/2;
			if(arr[mid]>arr[h])
				l=mid+1;
			else
				h=mid;
		}
		return l;
	}
	
	public static void main(String[] args) {
		int arr[] = {5, 1, 2,3 };//{};
		
		System.out.println(findKRotation(arr, arr.length));

	}

}
