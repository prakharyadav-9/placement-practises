package com.py.sheet.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class Q06_GenerateAllParanthesis {

	static
	 public List<String> AllParenthesis(int n) {
	        // Write your code here
		 List<String> result = new ArrayList<>();
		 generateAll("(",1,0,result,n);
		 return result;
	 }
	private static void generateAll(String currentStr, int opening, int closing, List<String> result,int pairs) {
		if(currentStr.length()==2*pairs) {
			result.add(currentStr);
			return;
		}
		if(opening<pairs) {
			generateAll(currentStr+"(",opening+1,closing,result,pairs);
		}
		if(closing<opening) {
			generateAll(currentStr+")",opening,closing+1,result,pairs);			
		}
	}
	public static void main(String[] args) {
		int n=3;
		System.out.println(AllParenthesis(n));
		
	}

}
