package com.py.sheet.potd.gfg.Month02;

public class POTD_02_18 {

	/*
	 * Two Pointer Approach
	 */
	public static int appleSequence(int n, int m, String arr){
		int oranges=0;
		int firstOrange = -1;
		int maxApples=0;
		
		for(int i=0;i<n;i++) {
			char ch = arr.charAt(i);
			if(ch=='O') {
				oranges++;
			}
			while(oranges>m) {
				// when number of oranges reached m then reduced oranges to apple
				// such that oranges is equal t m
				firstOrange++;
				if(arr.charAt(firstOrange)=='O') {
					// discarding this extra Orange
					// converting in to an Apple
					oranges--;
				}
			}
			maxApples  = Math.max(maxApples, i-firstOrange);
			// updating the length of first result
		}
		return maxApples;
	}
	public static void main(String[] args) {
		String str = "AOOAO";//"AAOAO";//
		int n = str.length();
		int m = 1;
		System.out.printf("Maximum consecutive Apples :: %d",appleSequence(n,m,str));

	}

}
