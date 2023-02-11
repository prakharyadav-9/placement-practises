package com.py.sheet.potd.gfg;

import java.util.HashSet;
import java.util.Set;

public class POTD_02_11 {

	
	/*
	 * GIven a string[len = n] and int array permutation of [0 (n-1)] 
	 * we can access ith value of array in (i+1)th day
	 * 
	 * tell the minimum number of days required, 
	 * such that after it for all index i (0<=i<N-1), 
	 * 		if S[i]!='?', then S[i]!=S[i+1]
	 */
	
	public static int getMinimumDays(int n, String str, int[] arr) {
        // code here
		int days=0;
		boolean check=false;
		// first step checking that the i == i+1
		for(int i=1;i<n;i++) {
			if(str.charAt(i)==str.charAt(i-1)) {
				check=true;
				break;
			}
		}
		if(check) {
//			System.out.println("we need to do some operation");
			Set<Integer> indxs = new HashSet<>();
			for(int i=1;i<n;i++) {
				int pick= arr[i-1];
				if(pick==(n-1) ) { //|| pick==0
					char ch0 = str.charAt(pick-1), ch1 = str.charAt(pick);
					if(ch0==ch1 && (!indxs.contains(pick) || !indxs.contains(pick-1))) {
						days++;
						indxs.add(pick);
					}
				}
				else if(pick==0 && !indxs.contains(pick)) {
					char ch1 = str.charAt(pick), ch2 = str.charAt(pick+1);
					if(ch1==ch2 && (!indxs.contains(pick) || !indxs.contains(pick+1))) {
						indxs.add(pick);
						days++;
					}
				}else {
					char ch2=str.charAt(pick+1) ,ch1=str.charAt(pick), ch0= str.charAt(pick-1);
					if((ch1==ch2 || ch1==ch0) && (!indxs.contains(pick) 
							|| !indxs.contains(pick+1) || !indxs.contains(pick-1) )) {
						indxs.add(pick);
						days++;
					}
				}
			}
		}
		// if we dont have any repeated elements then simply return 0 
		return days;
    }
	
	public static void main(String ...arg) {
		String str= "aabb";//"aabb";//"abcd";//
		int arr[] = {2,1,3,0};
		
		System.out.printf("minimum days:: %d",getMinimumDays(arr.length, str, arr));
		
	}
}
