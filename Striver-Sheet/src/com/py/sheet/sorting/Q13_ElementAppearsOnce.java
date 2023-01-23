package com.py.sheet.sorting;

public class Q13_ElementAppearsOnce {

	public static int search(int arr[], int N)
    {
		
        int low=0,high=N-1;
        while(low<high) {
        	int mid=(high+low)/2;
        	// for even mid, ideally pairs come in (i,i+1)
        	/*
        	 *  so if arr[mid] == arr[mid+1] then left partition is perfect 
        	 *  		then change low
        	 *  
        	 *  	otherwise,
        	 *  		change high to mid
        	 *  	why mid?
        	 *  		because mid could be the element that is imperfect
        	 */
        	
        	
        	// for odd mid, ideally pairs come in (i-1,i)
        	/*
        	 * then numbers left side are even
        	 * so if arr[mid] == arr[mid-1] then left partition is perfect
        	 * 		then change low
        	 * 
        	 * 		otherwise,
        	 * 			change high=mid
        	 */
        	if((mid%2==0 && arr[mid] == arr[mid+1]) || (mid%2!=0 && arr[mid-1] ==arr[mid])) {
        		low = mid+1;
        	}else {
        		high=mid;
        	}
        }
        // low will point to the index of once occurence of element
        return arr[low];
    }
	
	public static void main(String[] args) {
		int arr[]={1, 2, 2, 5, 5};
		System.out.print(search(arr,arr.length));
	}

}
