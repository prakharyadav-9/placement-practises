package com.py.sheet.string.easy;

import java.util.HashMap;
import java.util.Map;

final class Q05_IsomorphicStrings {

	/*
	 * Given two strings 'str1' and 'str2', 
	 * check if these two strings are isomorphic to each other.
	 * 
	 * Two strings str1 and str2 are called isomorphic 
	 * if there is a one to one mapping possible 
	 * for every character of str1 to every character of str2 while preserving the order.
	 * 
	 * Note: All occurrences of every character in str1
	 *  should map to the same character in str2
	 */
	public static boolean areIsomorphic(String str1,String str2){
        Map<Character, Character> map = new HashMap<>();
        int s1Len = str1.length();
        if(s1Len!=str2.length())
        	return false;
        for(int i=0; i<s1Len;i++) {
        	char s1Char = str1.charAt(i);
        	if(!map.containsKey(s1Char)) {
        		map.put(s1Char,str2.charAt(i));
        	}else if(map.get(s1Char) != str2.charAt(i)) {
        		return false;
        	}
        }
        map.clear();
        for(int i=0; i<s1Len;i++) {
        	char s2Char = str2.charAt(i);
        	if(!map.containsKey(s2Char)) {
        		map.put(s2Char,str1.charAt(i));
        	}else if(map.get(s2Char) != str1.charAt(i)) {
        		return false;
        	}
        }
		return true;   
    }
	public static void main(String[] args) {
		String str1 = "pijthbsfy";//"xudzhi";//
		String str2 = "fuladzpbf";//"ftakcz";//
		System.out.println(areIsomorphic(str1, str2));
	}

}
