package com.py.sheet.sorting;

public class Q12_MaxSumOfKConsecutives {

	private static long maxSumKConsecutives(int []arr,int k) {
		long maxSum=0;
		
//		  Sum of first K elements
		for(int i=0;i<k;i++) {
			maxSum+=arr[i];
		}
		long currSum=maxSum;
		/*
		 * consicutively adding and removing first and last elements
		 * keeping a maximum sum
		 */
		for(int i=k;i<arr.length;i++) {
			currSum += (arr[i] - arr[i-k]);
			maxSum= Math.max(maxSum,currSum);
		}
				
		return maxSum;
	}
	public static void main(String[] args) {
		int array[] = {1,1000,2,3,50,4};//{10,7,6,5,3,9,2,1,8,4};
		int k=2;
		System.out.print(maxSumKConsecutives(array,k));

	}

}
