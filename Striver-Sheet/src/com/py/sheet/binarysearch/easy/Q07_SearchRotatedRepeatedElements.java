package com.py.sheet.binarysearch.easy;

public class Q07_SearchRotatedRepeatedElements {

	public static boolean Search(int N, int[] arr, int key) {
        // code here
        int l=0;
        int h=N-1;
        
        /*
         * this is shifting the index technique
         * till the sub-array is obtained where the element could possibly be
         */
        while(arr[l]>key && l<h) {
			l++;
		}
		while(arr[h]<key && h>0) {
			h--;
		}
		while(l<=h) {
			int mid=(l+h)/2;
			if(arr[mid]==key) {
				return true;
			}else if(arr[mid]>key) {
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		int arr[] ={2,5,6,0,0,1,2};
		int key=0;
		System.out.println(Search(arr.length,arr,key));

	}

}
