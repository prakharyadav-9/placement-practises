package com.py.sheet.potd.gfg.Month02;

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
	
	
	/* 
	 * MY SOLUTIONNNNNNNNN
	 
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
		Set<Integer> indxs = new HashSet<>();
		if(check) {
			for(int i=1;i<n;i++) {
				if(!(indxs.contains(arr[i]) || indxs.contains(arr[i]-1)
						|| indxs.contains(arr[i]+1) )
						) {					
					if((arr[i] ==0) && str.charAt(arr[i])== str.charAt(arr[i]+1)) {
						indxs.add(arr[i]);
						days++;
					}else if((arr[i]==n-1) && str.charAt(arr[i])== str.charAt(arr[i]-1)) {
						indxs.add(arr[i]);
						days++;
					}
					else if(str.charAt(arr[i]) == str.charAt(arr[i]-1) 
							|| str.charAt(arr[i]) ==str.charAt(arr[i]+1)) {
						indxs.add(arr[i]);
						days++;
					}
				}
			}
		}
		System.out.println(indxs);
		// if we dont have any repeated elements then simply return 0 
		return days;
    }
    
    */
	
	public static void main(String ...arg) {
		String str= "aabb";//"abcd";//
		int arr[] = {2,1,3,0};
		
		System.out.printf("minimum days:: %d",getMinimumDays(arr.length, str, arr));
		
	}
	
	/*
	 * SUBMITEDDDD
	 */
	public static int getMinimumDays(int N, String S, int[] P) {
        // code here
        char[] c = S.toCharArray();
        int ans=0;
        for(int i=0;i<N;i++) {
            int idx = P[i];
            if(idx==0) {
                if(idx+1<N && c[idx]==c[idx+1]) {
                    c[idx]='?';
                    ans = i+1;
                }
            } else if(idx==N-1) {
                if(idx-1>=0 && c[idx]==c[idx-1]) {
                    c[idx]='?';
                    ans = i+1;
                }
            } else {
                if(c[idx]==c[idx-1] || c[idx]==c[idx+1]) {
                    c[idx]='?';
                    ans = i+1;
                }
            }
        }
        return ans;
    }
}
