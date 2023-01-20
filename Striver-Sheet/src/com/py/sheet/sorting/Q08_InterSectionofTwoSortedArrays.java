package com.py.sheet.sorting;

public class Q08_InterSectionofTwoSortedArrays {

	static void printIntersection(int[] arr1, int[] arr2) {
		int i=0, j=0;
//		int printedNum=Integer.MIN_VALUE;
//		while(i<arr1.length && j<arr2.length) {
//			if(arr1[i]>arr2[j]) {
//				j++;
//			} if(j<arr2.length && arr1[i]<arr2[j]) {
//				i++;
//			}
//			if(i<arr1.length&&  j<arr2.length && arr1[i]==arr2[j] && arr2[j] != printedNum) {
//				System.out.print((printedNum=arr1[i])+ " ");
//			}
//			i++;
//			j++;
//		}
//		System.out.println();
		/*
		 * more optimized solution
		 * below
		 */
		i=0;j=0;
		while(i<arr1.length && j<arr2.length) {
			if(i>0 && arr1[i]== arr1[i-1]) {
				i++;
				continue;
			}
			if(arr1[i]<arr2[j])
				i++;
			else if(arr1[i ]> arr2[j])
				j++;
			else {
				System.out.print( arr1[i] + " ");
				i++;
				j++;
			}
				
			
		}
	}
	public static void main(String[] args) {
		int a[] = {2,20,20,40,60};//{3,5,10,10,10,15,15,20};
		int b[]= {2,10,20,20,20};//{5,10,10,15,30};
		printIntersection(a,b);
	}

}
