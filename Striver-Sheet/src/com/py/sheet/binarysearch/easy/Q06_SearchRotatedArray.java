package com.py.sheet.binarysearch.easy;

public class Q06_SearchRotatedArray {

	/*
	 * Given a sorted and rotated array A of N distinct elements
	 *  which is rotated at some point, and given an element key. 
	 * The task is to find the index of the given element key in the array A.
	 */
	static int search(int arr[], int l, int h, int key){
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
		
		while(l<=h) {
			 int mid=l+(h-l)/2;
	            if(arr[mid] == key)
	                return mid;
	            if(arr[l]<=arr[mid]){
	                if(key>=arr[l] && key<arr[mid])
	                    h=mid-1;
	                else
	                    l=mid+1;
	            }
	            else{
	                if(key>arr[mid] && key<arr[h])
	                    l=mid+1;
	                else
	                    h=mid-1;
	            }
		}
		
		/*
		 * Below is the shifting the index method
		 * it shifts the h and l index where the key could in between present
		 */
//		while(arr[l]>key && l<h) {
//			l++;
//		}
//		while(arr[h]<key && h>0) {
//			h--;
//		}
//		while(l<=h) {
//			int mid=(l+h)/2;
//			if(arr[mid]==key) {
//				return mid;
//			}else if(arr[mid]>key) {
//				h=mid-1;
//			}else {
//				l=mid+1;
//			}
//		}
		return -1;
    }
	public static void main(String[] args) {
		int arr[]={3, 5, 1, 2};//{5, 6, 7, 8, 9, 10, 1, 2, 3};
		int key=10;
		System.out.println(search(arr,0,arr.length-1,key));

	}

}
