package com.py.sheet.potd.gfg.Month02;

public class POTD_02_04 {

	static int maxSum(int arr[], int size, int startIdx) {

		/*
		 * striver space optimization with tabulation
		 * 
		 * 	i added a feature that 
		 * 	we can take a start index from where 
		 *  we can start taking the elements
		 */
		int prev2=0;
		int prev1=arr[startIdx];
		for(int i=startIdx+1;i<size;i++) {
			int taken= arr[i];
			if(i>1)
				taken+=prev2;
			int notTaken = prev1;
			int current = Math.max(taken,notTaken);
			prev2=prev1;
			prev1= current;
		}
		
		return prev1;
		/*
		 * Below is my solution which is based on recurssion 
		 * T.C. = O(n)
		 * S.C. = O(n)
		 */
//		if(startIdx >= size) {
//			return 0;
//		}
//		if(size==startIdx-1)
//			return arr[size-1];
//		
//        int taken = arr[startIdx] + maxSum(arr,size,startIdx+2);
//        int notTaken = maxSum(arr,size,startIdx+1);
//		return Math.max(taken,notTaken);
	}

	
	static int findMaxSum(int arr[], int n) {
	        if (n==1)
	            return arr[n-1];
	        
	        return maxSum(arr,n,0);
	 }
	public static void main(String[] args) {
		int arr[] = {3, 2, 7, 10};//{5, 5, 10, 100, 10, 5}; //{4,4,10, 6, 9, 7, 5, 7};
		System.out.println(findMaxSum(arr, arr.length));
		
	}

}
