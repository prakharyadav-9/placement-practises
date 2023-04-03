package com.py.sheet.recursion.playlist;

import java.util.Stack;

public class V07 {
	static boolean reached= false; // not recommended 

	public static void main(String[] args) {
		int arr[] = {1,2,1};
		int target=2;
		Stack<Integer> s= new Stack<>();
		//printSubsquenceesToSumK(0,s,0,k,arr);
		s.clear();
//		printAnySubSeqSumK(0,s,0,k,arr);
		s.clear();
		System.out.println(countSubSequencesSumK(0,s,0,target,arr));
	}

	
	private static int countSubSequencesSumK(int i, Stack<Integer> s, int currSum, int target, int[] arr) {
		// only when all elements are positive
		if(currSum>target)
			return 0;
		if(currSum==target) {
			System.out.println(s);
			return 1;
		}
		int l=0;
		int r = 0;
		if(i+1<=arr.length) {
			s.push(arr[i]);
			l+=countSubSequencesSumK(i+1, s, currSum+arr[i], target, arr); // pick
			s.pop();
			l+=countSubSequencesSumK(i+1, s, currSum, target, arr); // not pick
		}
		return l+r;
		
	}

	/*
	 * @param idx 
	 * @param s = elements in order
	 * @param currSum = current sum
	 * @param k = target
	 * @param array = arr
	 */
	private static void printAnySubSeqSumK(int idx, Stack<Integer> s, int currSum, int k, int[] arr) {
		boolean  res= f(idx,s,currSum,k,arr);
		if(!res)
			System.out.println("no sub sequence possible");
	}

	private static boolean f(int idx, Stack<Integer> s, int currSum, int k, int[] arr) {
		if(currSum == k) {
			System.out.println(s);
			return true;
		}
		if(idx+1<=arr.length) {
			s.push(arr[idx]);
			if(f(idx+1, s,currSum+arr[idx],k,arr)) {
				System.out.println("-> "+s);
				return true;
			}
			s.pop();
			if(f(idx+1,s,currSum,k,arr))
				return true;
		}
		return false;
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
			reached = !reached;
			return;
		}
		// handling outof index
		if(i+1<=arr.length ) /* && !reached)*/  
		{
			s.push(arr[i]);
			printSubsquenceesToSumK(i+1, s, j+arr[i], k, arr); // pick ith idx
			s.pop();
			printSubsquenceesToSumK(i+1, s, j, k, arr);       // not pick ith idx
		}
	}

}
