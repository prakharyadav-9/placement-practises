package com.py.sheet.array.medium;

import java.util.Arrays;

public class Q20_AlternativePosAndNeg {

	static void rearrange(int arr[], int n) {
		int negs =0, poss=0;
		int i,j=0,k=0;
		for(int ele:arr)
			if(ele<0)
				negs++;
			else
				poss++;
		int neg[] = new int[negs];
		int pos[] = new int[poss];
		for(int ele:arr)
			if(ele<0)
				{
				neg[j++] = ele;
				}
			else {
				pos[k++] = ele;
			}
		
		for(i=0,j=0,k=0;j<pos.length &&k<neg.length ;i++) {
			if(i%2==0) {
				arr[i] = pos[j];
				j++;
			}else if(i%2!=0  ) {
				arr[i] = neg[k];
				k++;
			}
		}
		while(j<pos.length) {
			arr[i++]=pos[j++];
		}
		while(k<neg.length) {
			arr[i++]=neg[k++];
		}
	}
	
	public static void main(String[] args) {
		int arr[]= {9, 4, -2, -1, 5, 0, -5, -3, 2};/* 9 -2 4 -1 5 -5 0 -3 2 */
		int arr1[]={-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}; /* 5 -5 2 -2 4 -8 7 1 8 0 */
		rearrange(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
