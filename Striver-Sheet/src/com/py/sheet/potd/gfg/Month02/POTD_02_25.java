package com.py.sheet.potd.gfg.Month02;

public class POTD_02_25 {
	

    static int checkCompressed(String S, String T) {
        // code here
    	int sLen = S.length(),tLen=T.length();
    	if(sLen==0 || T.length()==0) {
    		return 0;
    	}
    	int i=0,j=0;
        char ch2;//= T.charAt(j);
        char ch1;//=S.charAt(i);
        while(j<tLen&&i<sLen){
        	int jumpTo = 0;
        	while(j<tLen && T.charAt(j)<='9') {
        		ch2 = T.charAt(j++);
        		jumpTo= jumpTo*10 +(ch2-'0');
        	}
        	i+=jumpTo;
        	if(i==sLen && j==tLen)
        		return 1;
        	if(i>=sLen|| j>=tLen)
        		return 0;
        	ch1 = S.charAt(i);
        	ch2 = T.charAt(j);
        	if(ch1!=ch2)
        		return 0;
        	
        	i++;
        	j++;
        }
        if(j!=tLen)
        	return 0;
        return 1;
    }


	public static void main(String[] args) {
		String S="A";//"GOUAPUI";//ABCD";//"GEEKSFORGEEKS";//"AABCDEFGHIJ";//"GEEKSFORGEEKS";//"DFD";//"DFS";//"GEEKSFORGEEKS";//
		String T = "A10000000000000";//"GOUA0P1I";//"4D";//"G7G3S";//"A10";//"D1S";//"D1S";//"G7G3S";//
		System.out.printf("isValid:: %d",checkCompressed(S, T));
		
	}

}
