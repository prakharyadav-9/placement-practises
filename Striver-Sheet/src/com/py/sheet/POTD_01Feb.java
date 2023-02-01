package com.py.sheet;

public class POTD_01Feb {

	public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        //code here
		// initialising a DP
		long dp[][] = new long[N][3];
		
		// fill initial value
		dp[0][0] = r[0]; // column 1 : red
		dp[0][1] = g[0]; // column 2 : green
		dp[0][2] = b[0] ;// column 3 : blue
		
		// run loop from 2nd house to last house 
		for(int i=1;i<N;i++) {
			dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+ r[i]; // ith iteration choosing red
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+ g[i]; // ith iteration choosing green
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b[i];// ith iteration choosing blue
		}
		// returning the minimum cost value till the last host 
		return Math.min(Math.min(dp[N-1][0],dp[N-1][1]), dp[N-1][2]);
	}
	public static void main(String[] args) {
		int r[] = {1, 1, 1},
		g[] = {2, 2, 2},
		b[] = {3, 3, 3};
		int n=3;
		
		System.out.println(distinctColoring(n,r, g, b));

	}

}
