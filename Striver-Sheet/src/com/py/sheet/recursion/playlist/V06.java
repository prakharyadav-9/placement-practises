package com.py.sheet.recursion.playlist;

import java.util.Stack;

public class V06 {

	/*
	 * Print subsequence
	 */
	static void subSequence(int idx,int arr[], Stack<Integer> elements) {
		if(idx>=arr.length){
			System.out.println(elements);
			return;
		}
		subSequence(idx+1,arr,elements); //  not take idx
		elements.push(arr[idx]);
		subSequence(idx+1,arr,elements); // take idx
		elements.pop();
	}
	
	public static void main(String[] args) {
		int arr[] = {3,1,2};
		Stack<Integer> s = new Stack<>();
		subSequence(0,arr,s);
	}

}
