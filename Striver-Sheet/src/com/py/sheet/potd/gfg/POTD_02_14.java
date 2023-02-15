package com.py.sheet.potd.gfg;

public class POTD_02_14 {


	/*
	 * More OPtimized code::
	 * 
	 */
	static
	int minCost(int [][] colors){
        //Write your code here
		int N = colors.length;
		for(int i=N-2; i>=0; i--){
            colors[i][0] += Math.min( colors[i+1][1], colors[i+1][2] );
            colors[i][1] += Math.min( colors[i+1][0], colors[i+1][2] );
            colors[i][2] += Math.min( colors[i+1][0], colors[i+1][1] );
        }
        return Math.min( colors[0][0], Math.min( colors[0][1], colors[0][2] ) );
    }
	
	static
	int minCost(int [][] colors, int N){
        //Write your code here
		int dp [] = new int [3];
		dp[0] = colors[0][0];
		dp[1] = colors[0][1];
		dp[2] = colors[0][2];
		
		for(int i=1;i<N;i++) {
			int minPink = colors[i][0] + Math.min(dp[1],dp[2]);
			int minBlack = colors[i][1] + Math.min(dp[0],dp[2]);
			dp[2] = colors[i][2] + Math.min(dp[1],dp[0]);
			dp[0] = minPink;
			dp[1] = minBlack;
		}
		return Math.min(dp[0],Math.min(dp[1],dp[2]));
		
    }
	
	public static void main(String[] args) {
		int costs[][] =  {
//				{14, 2, 11},
//	            {11, 14, 5},
//	            {14, 3, 10}
				{1,2,3},
				{1,4,6},
				
	             };
		System.out.println(minCost(costs, costs.length));
	}

}
