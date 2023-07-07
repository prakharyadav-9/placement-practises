package com.py.potd.gfg._2023.Month02;

public class POTD_02_21 {

	
	public static int minIteration(int N, int M, int x, int y){
		//code here
		int top = x-1;
		int down = N-x;
		
		int left = y-1;
		int right = M-y;
		int maxXdir = Math.max(left,right);
		int maxYdir = Math.max(top,down);
		return maxYdir+maxXdir;
	} 
	
	public static void main(String[] args) {
		int N= 1, M = 1;
		int x= 1, y=1;
		
		System.out.printf("Minimum Iterations Required :: %d", minIteration(N, M, x, y));

	}

}
