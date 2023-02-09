package com.py.sheet.binarysearch.Hard;

public class Q16_KokoEatingBananas {

	public static int Solve(int N, int[] arr, int H) {
        // code here
		if(N==H) {
			int max  = arr[0];
			for(int i=1;i<N;i++) {
				max = max>arr[i]?max:arr[i];
			}
			return max;
		}else { // means H>N
			long sum = 0;
			for(int ele:arr) {
				sum+=ele;
			}
			double ans= Math.ceil(((double)sum/H));
			return (int)ans;//(int) Math.ceil((sum/H));
			
		}
    }
	
	
	public static void main(String[] args) {
		int arr[] = {3, 6, 7, 11};// {30, 11, 23, 4, 20};
		int H = 8;//5;
		System.out.println(Solve(arr.length,arr,H));
	}

}
