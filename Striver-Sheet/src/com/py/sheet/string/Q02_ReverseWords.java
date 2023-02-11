package com.py.sheet.string;

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
		String[] splittedString = S.split("\\.");
		for(int i= splittedString.length-1;i>0;i--) {
			result.append(splittedString[i]).append('.');
		}
		result.append(splittedString[0]);
		return result.toString();
    }
	
	public static void main(String[] args) {
		String str = "i.like.this.program.very.much";
		System.out.printf("result is:: %s",
				reverseWords(str));
	}

}
