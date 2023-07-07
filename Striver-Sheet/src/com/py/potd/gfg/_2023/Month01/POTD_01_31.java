package com.py.potd.gfg._2023.Month01;

public class POTD_01_31 {

	/*
	 * Given two strings A and B. 
	 * Find minimum number of times A has to be repeated such that B is a Substring of it. 
	 * If B can never be a substring then return -1.
	 */
	
	static int minRepeats(String A, String B) {
        // code here
		int j=0;
		// char ch1= B.charAt(j);
		int i= A.indexOf(B.substring(0, 2));;//A.indexOf(ch1);
		
		if(i==-1) {
			return i;
		}
		int times=1;
        int aLen= A.length(),bLen=B.length();
        while(j<bLen && A.charAt(i) == B.charAt(j)) {
        	j++;
        	if(j==bLen)
        		break;
        	i= (i+1)%aLen;
        	if(i == 0)
        		times++;
        }
        
        if(j!=bLen) {
        	return -1;
        }
//        if(aLen)
//        System.out.println(i);
        return times;
    }
	
	public static void main(String[] args) {
		String a="abad";//"ww";//"abcd";
		String b = "adab";//"wwww";//cdabcdab";
		System.out.println(minRepeats(a,b));
	}

}
