package com.py.sheet.binarysearch.easy;

public class Q02_FindFloor {

	// Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x){
    	int low = 0;
        int high = n-1;
        int floor = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==x)return mid;
            else if(arr[mid]>x){
                high = mid-1;
            }else{
                //we find the smallest number than x
                floor = mid;
                //but we have to find the largest in smallest number,so we move further
                low = mid+1;
            }
        }
        return floor;
    }
    
	public static void main(String[] args) {
		long arr[] = {1,2,8,10,11,12,19};
		long x=3;
		System.out.println(findFloor(arr,arr.length,x));

	}

}
