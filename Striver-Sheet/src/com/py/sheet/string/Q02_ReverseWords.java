package com.py.sheet.string;

import java.util.Stack;

public class Q02_ReverseWords {

	 /*
	 * Given a String S, 
	 * reverse the string without reversing its individual words. 
	 * Words are separated by dots.
	 */
	static 
	String reverseWords(String S){
        // code here 
		int len= S.length();
		StringBuilder result = new StringBuilder(len);
		Stack<Character> stack = new Stack<>();
		for(int i= len-1;i>=0;i--) {
			char ch= S.charAt(i);
			if(ch!='.') {
				stack.push(ch);
			}else {
				while(!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append('.');
			}
		}
		while(!stack.isEmpty()) {
			result.append(stack.pop());
		}
        return result.toString();
    }
	
	public static void main(String[] args) {
		String str = "i.like.this.program.very.much";
		System.out.printf("result is:: %s",
				reverseWords(str));
	}

}
