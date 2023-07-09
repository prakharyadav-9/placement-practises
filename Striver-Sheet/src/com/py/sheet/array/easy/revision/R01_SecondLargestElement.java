package com.py.sheet.array.easy.revision;

import java.util.Arrays;

public class R01_SecondLargestElement {
    /**
     * get the second largest in the array
     * @param arr Array
     * @param n size of array
     * @return secLarg secondLargest
     */
    static int print2largest(int arr[], int n) {
        int larg=Integer.MIN_VALUE, secLarg=larg;
        for(int i=0;i<n;i++){
            // * Idea is get the largest as is, meanwhile also update secondLargest
            if(larg<arr[i]){
                secLarg=larg;
                larg=arr[i];
            }
            // * also check for the current traversing element is greater than secLarge if so Update it
            if(arr[i]>secLarg&&arr[i]!=larg){
                secLarg=arr[i];
            }
        }
        return secLarg;
    }
	public static void main(String[] args) {
		int arr[] = {10,5,10,9,3,7,9};
		System.out.println(Arrays.toString(arr));
		System.out.println(print2largest(arr, arr.length));
	}
}
