package com.py.sheet.sorting;

public class Q06_RotateDPlaces {

	/*
	 * use reversal method
	 */
	static void leftRotate(int[] arr, int n, int d) {
		
	}
	
	public static void main(String[] args) {
		int a[] = {1,2};//2,3};//{1,1,2};//{1,1,2};//{1,3,4,5,6,12,17,19,28,28};//{2,20,20,40,60};//{3,5,10,10,10,15,15,20};
		int d= 12;
		leftRotate(a,a.length,d);
		System.out.print("Elements-> [");
		for(int ele:a) {
			System.out.print(ele + " ");
		}
		System.out.println("]");
	}

}
