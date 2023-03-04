package com.py.sheet.recursion.playlist;

import java.util.Arrays;

public class V04 {
	
	private static void q1_recursiveReverseAnArray() {
		int arr[] = {1,2,3,4,5,};//{1,2};//
		System.out.printf(" initial array:: %s\n",Arrays.toString(arr));
		reverseArray(arr,0,arr.length-1);
		reverseArray(arr,0);
		System.out.printf(" reversed array:: %s",Arrays.toString(arr));
	}
	
	
	private static void reverseArray(int[] arr, int i) {
		if(i<arr.length/2) {
			int t = arr[i];
			int last = arr.length-1 - i;
			arr[i] = arr[last];
			arr[last] = t;
			reverseArray(arr,i+1);
		}
	}


	private static void reverseArray(int[] arr,int first,int last) {
		if(first<last) {
			int t = arr[first];
			arr[first] = arr[last];
			arr[last] = t;
			reverseArray(arr, first+1, last-1);
		}
	}


	
	
	private static void q2_checkPalindromeStr() {
		String str = "aaaa0aaaa";
		System.out.printf("%b",checkPalindrome(str,0));
	}
	
	private static boolean checkPalindrome(String str,int idx) {
		if(idx <str.length()/2) {
			int last = str.length()-1-idx;
			if(str.charAt(idx)!=str.charAt(last))
				return false;
			else
				return checkPalindrome(str, idx+1);
		}
		
		return true;
	}


	public static void main(String ...args) {
//		q1_recursiveReverseAnArray();
		q2_checkPalindromeStr();
	}




}
