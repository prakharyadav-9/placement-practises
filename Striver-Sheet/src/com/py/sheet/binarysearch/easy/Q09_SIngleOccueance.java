package com.py.sheet.binarysearch.easy;

public class Q09_SIngleOccueance {

	static int findOnce(int arr[], int n)
    {
        // Complete this function

		int lo=0, hi=n-1, mid;
        while(lo<hi) {
            mid=(lo+hi)>>1;
            if((mid & 1) !=0) 
            	mid--;
            if(arr[mid]==arr[mid+1])
            	lo=mid+2;
            else 
            	hi=mid;
        }
        if(lo<n)
        	return arr[lo];
        return 0;
    }
	
	public static void main(String[] args) {
		int arr[] = {1,1, 2,2, 3, 3,-4,-4, 50, 50, 65, 65};
		System.out.println(findOnce(arr, arr.length));
	}

}
