package com.py.sheet.string.easy;

public class Q11_MaxParanthesisDepth {

	 
	public static int maxDepth(String s) {
        // code here
		int maxDep = 0;
		int dep=0;
		int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                dep++;
                maxDep = Math.max(dep,maxDep);
            }else if(ch == ')'){
                dep--;
            }
        }
		return maxDep;
    }
	public static void main(String[] args) {
		String s = "((5+2)(c+e)((a)))";
		System.out.printf("Max depth:: %d",maxDepth(s));

	}

}
