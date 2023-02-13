package com.py.sheet.binarysearch.Hard;

import java.util.Arrays;

final class Q21_AggressiveCows {
	/*
	 * T.C. = O(N*log(N))
	 * S.C. = O(1)
	 */
	public static int solve(int n, int k, int[] stalls) {
		int minDist = 1,maxDist = Integer.MIN_VALUE;
		// approach :
//		 	1. sort
//			2. max distance could be (lastStall -1)
//			3. use BS to get a distance where placing cow is possible
//			4. if placing cows with mid is possible the ans = mid and move l =mid+1
//			5. else move h=mid -1, [that is mid and beyond cow placing was not possible]
		Arrays.sort(stalls);
		maxDist = stalls[n-1] -1;
		// search space => [minDistance maxDistance=(maxStall-1)]
		int ans=1;
		while(minDist<=maxDist) { // O(log(N))
			int midDist = minDist+ (maxDist- minDist)/2;
			if(isPlacingPossible(stalls,midDist, k)) {
				ans=midDist;
				minDist = midDist+1;
			}else {
				maxDist = midDist-1;
			}
		}
		return ans;
	}
	// placing cows in stalls with minDistance 
	// O(N)
	private static boolean isPlacingPossible(int[] stalls, int distance, int cows) {
		int lastPlaced = stalls[0];
		cows-=1;
		for(int i=1;i<stalls.length && cows!=0;i++) {
			if((stalls[i]-lastPlaced)>=distance) {
				cows--;
				lastPlaced=stalls[i];
			}
		}
		return cows==0?true:false;
	}

	public static void main(String[] args) {
		int arr[]= {31,27,8,33,32,20,7,24,23, 3,26,9};//{10,1,2,7,5};//{1,2,4,8,9};
		int k=7;//3;
//		System.out.println(isPlacingPossible(arr, 4, k));
		System.out.println(solve(arr.length,k,arr));
	}

}
