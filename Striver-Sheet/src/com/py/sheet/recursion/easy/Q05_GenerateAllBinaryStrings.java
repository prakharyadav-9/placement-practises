package com.py.sheet.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class Q05_GenerateAllBinaryStrings {

	public static List<String> generateBinaryStrings(int n) {
	    // code here
	    List<String> result = new ArrayList<>();
	    generateAndAddToList(n,result,"");
	    return result;
	  }
	
	private static void generateAndAddToList(int n, List<String> result,String currStr) {
		if(n==0) {
			result.add(currStr);
			return;
		}
		generateAndAddToList(n-1,result,currStr+"0");
		if(currStr.length()==0 || currStr.charAt(currStr.length()-1) != '1')
			generateAndAddToList(n-1,result,currStr+"1");
	}

	public static void main(String[] args) {
		int n=3;
		System.out.println(generateBinaryStrings(n));
	}

}
