package com.py.sheet.binarysearch.Hard;

import java.util.Arrays;

final class Q21_AggressiveCows {

	public static int solve(int n, int k, int[] stalls) {
		int minStall = Integer.MAX_VALUE,maxStall = Integer.MIN_VALUE;
		// approach :
//		 	1. sort
//			2. make least and max as two selected stalls
//			3. find mid
//			3. search for closest mid in stalls[]
//			4. switch to side where number of stalls are more
		Arrays.sort(stalls);
		k=k-2;
//		for(int stall: stalls) {
//			minStall = minStall>stall?stall:minStall;
//			maxStall = maxStall<stall?stall:maxStall;
//		}
		// search space => minStall maxStall
		
		while(minStall<=maxStall) {
			int midStall = minStall + (maxStall- minStall)/2;
			
		}
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,4,8,9};
		int k=3;
		
		System.out.println(solve(arr.length,k,arr));
	}

}
