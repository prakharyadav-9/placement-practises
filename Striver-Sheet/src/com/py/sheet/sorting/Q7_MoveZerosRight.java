package com.py.sheet.sorting;

import java.util.Arrays;

public class Q7_MoveZerosRight {
	
	private static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	/*
	 * Move zeros to right and maintain order
	 */
	static void pushZerosToEnd(int[] arr, int n) {
		int i=0;
		for(int j=0;j<n;j++) {
			if(arr[j]!=0) {
				swap(arr,i,j);
				i++;
			}
		}
		
		/*
		 * below logic would cause TLE for test cases
		 * 000000000010000000000000002000000000000003000000000000040000000000000005066666666
		 */
//        int numZeros=0;
//        for(int i=0;i<n;i++) {
//        	if(arr[i]==0)
//        		numZeros++;
//        }
//		
//        for(int i=0;i<n-numZeros;i++) {
//        	if(arr[i]==0) {
//        		int j=i+1;
//        		do {
//        			if(arr[j]!=0)
//        				swap(arr,i,j);
//        			j++;
//        		}while(arr[i]==0 && j<n);
//        	}
//        }
    }
	public static void main(String[] args) {
		int a[] = {0,0,0,0,0,1,2,3,4,5,6};//{0,0,0,0,3,0,1,0,2,0};//2,3};//{1,1,2};//{1,1,2};//{1,3,4,5,6,12,17,19,28,28};//{2,20,20,40,60};//{3,5,10,10,10,15,15,20};
		pushZerosToEnd(a,a.length);
		System.out.print(Arrays.toString(a));
	}

}
