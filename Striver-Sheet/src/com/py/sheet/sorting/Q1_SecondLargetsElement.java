package com.py.sheet.sorting;

import java.util.Arrays;

public class Q1_SecondLargetsElement {

	static int print2largest(int arr[], int n) {
        int [] tmp= new int[2];
        tmp[1]=tmp[0]= Integer.MIN_VALUE+2;
        for(int i=0;i<n;i++) {
        	tmp[0]= Math.max(arr[i],tmp[0]);
        }
        for(int i=0;i<arr.length;i++) {
        	if(arr[i]!= tmp[0]) {
        		tmp[1]= Math.max(arr[i],tmp[1]);
        	}
        }
        return tmp[1];
    }
	public static void main(String[] args) {
		int arr[] = {10,5,10,2,3,7,9};
		System.out.println(Arrays.toString(arr));
		System.out.println(print2largest(arr, arr.length));
	}

}
