package com.py.sheet.binarysearch.easy;

public class Q13_FindNthRootUsingBS {

	static  double power(double x,long y ) {
		double ans=1l;
		for(int i=1;i<=y;i++) {
			ans=ans*x;
		}
		return ans;
	}
	static long floorSqrt(long x)
	 {
		// Your code here
		int n=3;
		return findNthRoot(n, x);
	 }
	
	static long findNthRoot(long n, long m) {
		
//		double low = 1;
//        double high = m;
//        double eps = 1e-7; 
//        
//        while((high - low) > eps) {
//            double mid = (low + high) / 2.0; 
//            if(power(mid, n) < m) {
//                low = mid; 
//            }
//            else {
//                high = mid; 
//            }
//        }
//        return (long) low;
		double l=1;
		double h= m;
		while((h-l)>1e-7) {
			double mid = (h+l)/2d;
			if(power(mid,n)<m) {
				l=mid;
			}else {
				h=mid;
			}
		}
		return (long) l;
	}
	public static void main(String[] args) {
		int x=9;
		System.out.println(floorSqrt(x));

	}

}
