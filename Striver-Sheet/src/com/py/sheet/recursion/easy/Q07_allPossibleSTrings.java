package com.py.sheet.recursion.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Q07_allPossibleSTrings {
	
	static
	public List<String> AllPossibleStrings(String s){
        // Code here
        List<String> result = new ArrayList<>();
		Stack<Character> stk = new Stack<>();
        int n  = s.length();
        generateAndAdd(s,result,stk,0,n);
        result.sort(null);
        return result;
    }
	static
	private void generateAndAdd(String s, List<String> result,Stack<Character> stk , int i, int n) {
		if(i>=n){
			// System.out.println("stack-> "+stk);
			StringBuilder str= new StringBuilder();
			Iterator itr =stk.iterator();
			while(itr.hasNext()){
				str.append(itr.next());
			}
			if(str.length()>0){
				result.add(str.toString());
			}
			return;
		}
		// System.out.println(s.charAt(i));
		// pick 
		generateAndAdd(s, result,stk, i+1, n);
		stk.push(s.charAt(i));
		generateAndAdd(s, result,stk, i+1, n);
		stk.pop();
		// not pick
	}
	public static void main(String[] args) {
		String s= "abc";
		System.out.println(AllPossibleStrings(s));
	}

}
