package com.py.sheet.string.easy;

import java.util.Arrays;

public class Q07_CheckAnagram {

	/*
	 * Given two strings a and b consisting of lowercase characters. 
	 * 	The task is to check whether two given strings are an anagram of each other or not.
	 *  An anagram of a string is another string that contains the same characters, 
	 *  only the order of characters can be different. 
	 * 
	 * For example, act and tac are an anagram of each other.
	 */
	public static boolean isAnagram(String a,String b){
        // Your code here
		int aLen = a.length(), bLen= b.length();
		int arr[] = new int [26];
		Arrays.fill(arr,0);
		for(int i=0;i<aLen;i++) {
			arr[a.charAt(i)-'a'] ++;
		}
		for(int i=0;i<bLen;i++) {
			arr[b.charAt(i)-'a']--;
		}
		for(int i=0;i<26;i++) {
			if(arr[i]!=0) {
				return false;
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		String s1 = "bb",//"allergy",//"geeksforgeeks",
				s2 = "bb";//"allergic";//"forgeeksgeeks";
		System.out.println(isAnagram(s1,s2));
		
	}

}
