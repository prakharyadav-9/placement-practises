package com.py.sheet.recursion.playlist;

public class V05 {

	
	/*
	 * Multiple Recursive calls
	 */
	
	static int fibo(int n) {
		if(n<=1) {
			System.out.println(n);
			return n;
		}
		int secLast = fibo(n-2);
		int last = fibo(n-1);
		System.out.println(last+secLast);
		return last+secLast;
	}
	
	public static void main(String[] args) {
		int n=3 ;
		System.out.printf("fibonacci of %d is %d",n,fibo(n));
	}

}
