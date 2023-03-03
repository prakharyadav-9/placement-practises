package com.py.sheet.recursion.playlist;

public class V02 {

	/*
	 * Print N -> 1
	 */
	static
	void printSequence(int N) {
		if(N==0)
			return ;
		System.out.printf("%d ",N);
		printSequence(N-1);
	}
	
	
	public static void main(String[] args) {

		int N = 5;
		printSequence(N);
		System.out.println();
	}

}
