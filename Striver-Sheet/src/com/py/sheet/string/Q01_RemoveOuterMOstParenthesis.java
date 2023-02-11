package com.py.sheet.string;

import java.util.Stack;

class Q01_RemoveOuterMOstParenthesis {

	public static String removeOuter(String s) {
        // code here
		int len = s.length();
		StringBuilder result = new StringBuilder(len);
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<len;i++) {
			char ch = s.charAt(i);
			if(ch=='(') {
				if(stack.size()>0) {
					result.append(ch);
				}
				stack.push(ch);
			}else {
				stack.pop();
				if(stack.size()>0) {
					result.append(ch);
				}
				
			}
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		final String str = "(()())(())";
		System.out.printf("Result string = %s",removeOuter(str));

	}

}
