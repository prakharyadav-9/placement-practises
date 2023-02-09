package com.py.sheet.binarysearch.easy;

public class Q11_KthElementin2SortedArray {

	static  public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int i=0,j=0;
		while(i<n&& j<m) {
			k--;
			int element = arr1[i]>arr2[j]?arr2[j++]:arr1[i++];
			if(k==0) {
				return element;
			}
		}
		// if either of the array is left 
		if(j<m) {
			return arr2[j+k-1];
		}
		else {
			return arr1[i+k-1];
		}
    }
	public static void main(String[] args) {
		int arr1[] =  {2, 3, 6, 7, 9};//{1,2,3};// {100, 112, 256, 349, 770};
		int arr2[]= {1, 4, 8, 10};//{4,5,6,7,8,9,10};//{72, 86, 113, 119, 265, 445, 892};
		int k=5;
		System.out.println(kthElement(arr1, arr2, arr1.length, arr2.length, k));

	}

}
