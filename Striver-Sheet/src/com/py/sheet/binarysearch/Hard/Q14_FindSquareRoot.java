package com.py.sheet.binarysearch.Hard;

public class Q14_FindSquareRoot {

	static long floorSqrt(long x)
	 {
		// Your code here
		long l=1;
		long h=x;
		long ans=-1;
		while(l<=h) {
			long mid = (l+h)/2;
			long midPow = mid*mid;
			if(midPow==x)
				return mid;
			else if(midPow>x) {
				h=mid-1;
			}
			else {
				l=mid+1;
				ans=mid;
			}
		}
		return ans;
	 }
	
	public static void main(String[] args) {
		int x=27;
		System.out.println(floorSqrt(x));

	}

}
