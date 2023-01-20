package com.py.sheet.knowBasicMath;

public class CountDigitGFG {

	
	static int evenlyDivides(int N){
	     int res=0,n=N;
	     while(n>0){
	         int digit= n%10;
	        //  System.out.println(digit);
	         if(digit!=0 && N%digit==0) 
	             res++;
	         n/=10;
	     }
	     return res;
	}
	
	public static void main(String[] args) {
		int n=11342;
		System.out.println(evenlyDivides(n));

	}

}
