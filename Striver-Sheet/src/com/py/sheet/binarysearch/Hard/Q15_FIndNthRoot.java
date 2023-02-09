package com.py.sheet.binarysearch.Hard;

public class Q15_FIndNthRoot {

	/*
	 * You are given 2 numbers (n , m); the task is to find n√m (nth root of m).
	 * if exists 
	 * 	else,
	 * 		return -1
	 * 
	 */
	static public int NthRoot(int n, int m){
        // code here
		int l=1;
		int h=m;
		while(l<=h) {
			int mid=(l+h)>>1;
			int midPow = (int) Math.pow(mid,n);
			if(midPow == m)
				return mid;
			else if(midPow > m) {
				h=mid-1;
			}else {
				l=mid+1;
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NthRoot(3, 9));

	}

}
