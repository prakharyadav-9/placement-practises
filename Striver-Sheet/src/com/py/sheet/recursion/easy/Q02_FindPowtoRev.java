package com.py.sheet.recursion.easy;

public class Q02_FindPowtoRev {

	static
	long power(int N,int R){
        //Your code here
        
        return 0;
    }
	public static void main(String[] args) {
		int N= 2299;
		int rev = rev(N);
//		long ans = power(N,rev);
		System.out.println(rev);
	}

	static private int rev(int num) {
		if(num==0)
			return 0;
		return (num%10)*10+rev(num/10); 
	}
}
