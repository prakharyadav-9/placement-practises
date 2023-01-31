package com.py.sheet.binarysearch.easy;

public class Q03_SearchInsertPosofK {

	static int searchInsertK(int Arr[], int N, int k){
        // code here
		int low=0, high=N-1;
		int mid=(low+high)/2;
		while(low<=high) {
			mid=(low+high)/2;
			if(Arr[mid]==k)
				return mid;
			else if(Arr[mid]>k) {
				high= mid-1;
			}
			else {
				low= mid+1;
			}
		}
		System.out.println(low+ "  " + high+  " "+  mid);
		return low;
    }
	
	public static void main(String[] args) {
		int arr[]= {1, 3,5, 6};
		int k=7;
		System.out.println(searchInsertK(arr,arr.length,k));

	}

}
