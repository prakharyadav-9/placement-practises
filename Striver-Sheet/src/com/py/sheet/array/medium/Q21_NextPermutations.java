package com.py.sheet.array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q21_NextPermutations {

	private static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	/*
	 * Implement the next permutation, 
	 * which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers.
	 * If such arrangement is not possible, it must be rearranged to the lowest possible order 
	 * i.e. sorted in an ascending order.
	 * You are given an list of numbers arr[ ] of size N.
	 * 
	 * arr={1,2,3}
	 * 	all permutations - 
	 * 		1,2,3
	 * 		1,3,2
	 * 		2,1,3
	 * 		2,3,1
	 * 		3,1,2
	 * 		3,2,1
	 * 
	 * therefore next lexographical permutation of given array [1,2,3] => [1,3,2]
	 */
	static List<Integer> nextPermutation(int N, int arr[]){
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length <=1) {
        	result.add(arr[0]);
        	return result;
        }
        int i=arr.length-2;
        while(i>=0&& arr[i]>= arr[i+1]) {
        	i--;
        }
        if(i>=0) {
        	int j=arr.length-1;
        	while(arr[j]<=arr[i]) {
        		j--;
        	}
        	swap(arr,i,j);
        }
        reverse(arr,i+1,arr.length-1);
        for(int ele:arr) {
        	result.add(ele);
        }
        return result;
    }
	
	static void reverse(int arr[], int start, int end) {
		while(start<end)
			swap(arr,start++, end--);
	}
	
	public static void main(String[] args) {
		int arr[]= {1, 2, 3, 6, 5, 4}; // {3,2,1};
		System.out.println(nextPermutation(arr.length,arr));
	}

}
