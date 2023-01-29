package com.py.sheet.array.medium;

public class Q23_KadanesAlgo {

	public static void main(String[] args) {
		int arr[]= {-2,-3,4,-1,-2,1,5,-3}; //{-2,1,-3,4,-1,2,1,-5,4}; //
		System.out.println(maxSumofArray(arr,arr.length));
	}

	private static int maxSumofArray(int[] arr, int length) {
		int sum=0;
		/*
		 * kadane's algorithm: we carry a sub-array as long as it carries a positive sum
		 * 
		 */
		
		int maxSum = arr[0];
		for(int i=0;i<length;i++) {
			sum+=arr[i];
			if(sum>maxSum) {
				maxSum=sum;
			}
			if(sum<0) {
				sum = 0;
			}
		}
		
		/*
		 * this solution requires T.C. = O(N^2)
		 * basically we add up elements from i -> j and storing the maximum sum
		 */
//		int maxSum=Integer.MIN_VALUE;
//		for(int i=0;i<length;i++) {
//			int curSum=0;
//			for(int j=i;j<length;j++) {
//				curSum+=arr[j];
//				maxSum=Math.max(maxSum,curSum);
//			}
//		}
		return maxSum;
	}

}
