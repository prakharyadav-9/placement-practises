package com.py.sheet.string.easy;

public class Q06_CHeckRotatedString {

	/*
	 * Given two strings s1 and s2. 
	 * The task is to check if s2 is a rotated version of the string s1. 
	 * The characters in the strings are in lowercase.
	 */
	private static boolean checkRotations(String s1, String s2 ){
        // Your code here
		int index=-1,j=0;
        if(s1.length()!=s2.length())
            return false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(j)==s2.charAt(i)){
                j++;
                if(index==-1)
                    index=i;
            }
            else{
                if(j!=0)
                    i--;
                j=0;
                index=-1;
            }
        }
        if(index==-1)
            return false;
        for(int i=0;i<index;i++){
            if(s1.charAt(j++)!=s2.charAt(i))
                return false;
        }
        return true;
	}
	
	public static boolean areRotations(String s1, String s2 ){
		// Your code here
		return checkRotations(s1, s2)|| checkRotations(s2, s1);
	}
	
	public static void main(String[] args) {
		String s1= "geeksgeeksforgeeks",//"geeksforgeeks",
				s2="geeksgeeksgeeksfor" ; 
		System.out.printf("%B",(areRotations(s1,s2)));
		
	}
	
	// COde DIdint worked for multiple test cases
	/*
	 * calling return checkRotations(s1, s2)|| checkRotations(s2, s1);
	 */
	// but my logic worked for "geeksgeeksgeeksfor" && "geeksgeeksforgeeks"
//	private static boolean checkRotations(String s1, String s2 ){
//        // Your code here
//		int len = s1.length(),  i =0, j=0;
//		if(len != s2.length()) {
//			return false;
//		}
//		while( j<len && i<len &&s2.charAt(j)!=s1.charAt(i)) {
//			i++;
//		};
//		while( j<len && i<len &&s2.charAt(j) == s1.charAt(i)) {;
//		i++;
//		j++;
//		}
//		if(j==len && i!=len) {
//			return false;
//		}
//		i=0;
//		while(  j<len && i<len && s2.charAt(j) ==s1.charAt(i)) {
//			j++;
//			i++;
//		}
//		if(j!=len)
//			return false;
//		return true;
//	}

}
