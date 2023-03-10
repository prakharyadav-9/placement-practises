package com.py.sheet.recursion.playlist;

public class V03 {

	static int sum = 0;
	
	private static int printSum1(int n) {
		if(n==0)
			return n;
		return n+printSum1(n-1);
	}
	
	public static void main(String[] args) {
		int N = 3;
		System.out.println(sum);
		System.out.println(printSum1(N));
	}



}
