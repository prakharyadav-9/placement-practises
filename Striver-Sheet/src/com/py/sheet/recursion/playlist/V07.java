package com.py.sheet.recursion.playlist;

import java.util.Stack;

public class V07 {

	public static void main(String[] args) {
		int arr[] = {1,2,1};
		int k=2;
		Stack<Integer> s= new Stack<>();
		printSubsquenceesToSumK(0,s,0,k,arr);
	}

	/*
	 * @param carryIndx = i
	 * @param stack = s
	 * @param currentSum = j
	 * @param targetSum = k
	 * @param array = arr
	 */
	private static void printSubsquenceesToSumK(int i, Stack<Integer> s, int j, int k, int[] arr) {
		if(j==k) {
			System.out.println(s);
			return;
		}
		// handling outof index
		if(i+1<=arr.length) {
			s.push(arr[i]);
			printSubsquenceesToSumK(i+1, s, j+arr[i], k, arr); // pick ith idx
			s.pop();
			printSubsquenceesToSumK(i+1, s, j, k, arr);       // not pick ith idx
		}
	}

}
