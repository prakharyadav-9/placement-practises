package com.py.sheet.array.easy;

public class Q11_FindMissingNumber {

	public static void main(String[] args) {
		int N = 5,arr[] = {1, 4, 3};//{2, 5, 3, 1};
		System.out.println(missingNumber(arr,arr.length+1));
	}

	public static int missingNumber(int arr[], int N)
    {
		long totalSum=(N*(N+1))/2;
		long givenSum=0;
		for(int i:arr) {
			givenSum+=i;
		}
		return (int) (totalSum-givenSum);
		
		/*
		 * below solution is not an optimized solution
		 * space complexity = O(n)
		 * time complexity = O(n)
		 */
//         int num=-1;
//         int temp[] = new int[N];
//         for(int j=0;j<N;j++) {
//        	 temp[j]=num;
//         }
//         for(int i=0;i<arr.length;i++) {
//        	 temp[arr[i]-1]=arr[i];
//         }
//         for(int i=0;i<N;i++) {
//        	 if(temp[i]==-1) {
//        		 num = i;
//        		 break;
//        	 }
//         }
//         return num+1;
    }
}