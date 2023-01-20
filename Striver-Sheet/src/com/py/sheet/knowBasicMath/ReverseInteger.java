package com.py.sheet.knowBasicMath;

public class ReverseInteger {

	static public int reverse(int x) {
		long rev =0;
        while(x!=0){
        	rev = rev*10 + x%10;
            if(rev > Integer.MAX_VALUE || rev< Integer.MIN_VALUE)
                return 0;
            x/=10;
        }
        return (int)rev;
    }
	public static void main(String[] args) {
		int n=1534236469;//-2147483648;//1534236469;
		System.out.println(reverse(n));

	}

}
