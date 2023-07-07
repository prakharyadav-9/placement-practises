package com.py.potd.gfg._2023.Month02;

public abstract class POTD_02_13 {

	static int inSequence(int A, int B, int C){
        // code here
		if(C==0)
			return A==B?1:0;
		return (((B)%C-A )==0 && (B-A)/C >=0)?1:0;
    }
	
	public static void main(String[] args) {
		int a=1,b=3,c=2;
		
		System.out.println(inSequence(a, b, c));
	}

}
