package com.py.sheet.recursion.easy;

import java.util.ArrayList;
import java.util.List;

public class Q07_allPossibleSTrings {
	
	static
	public List<String> AllPossibleStrings(String s){
        // Code here
        List<String> result = new ArrayList<>();
        int n  = s.length();
        generateAndAdd(s,result,0,n);
        
        return result;
    }
	static
	private void generateAndAdd(String s, List<String> result, int i, int n) {
		if(i>=n)
			return;
		System.out.println(s.charAt(i));
		// pick 
		generateAndAdd(s, result, i+1, n);
		
		// not pick
		generateAndAdd(s, result, i+2, n);
	}
	public static void main(String[] args) {
		String s= "abc";
		System.out.println(AllPossibleStrings(s));
	}

}
