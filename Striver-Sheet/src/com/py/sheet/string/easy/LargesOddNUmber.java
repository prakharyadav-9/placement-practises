package com.py.sheet.string.easy;

class LargesOddNUmber {

	/*
	 * Given an string S, representing a large interger. 
	 * Return the largest-valued odd integer (as a string) 
	 * that is substring of the given string S.
	 */
	static
	String maxOdd(String s) {
        // code here
		StringBuilder result = new StringBuilder();
		int len = s.length();
		int lastIdx=-1;
		for(int i=len-1;i>=0;i--) {
			if((s.charAt(i)-'0')%2!=0) {
				lastIdx=i;
				break;
			}
		}
		for(int i=0;i<=lastIdx;i++) {
			result.append(s.charAt(i));
		}
		return result.toString();
		
		/*
		 * My interpretation of the question was
		 * find largest longest contigious odd numbers
		 * in the input string
		 */
//		int maxOdd = 0;
//		int prev  = 0;
//		for(int i=0; i<len;i++) {
//			int dig = s.charAt(i) - '0';
////			int nextDig = s.charAt(i+1)  - '0';
//			if(dig%2 !=0) { //simply number is odd
//				if(prev%2 !=0) {
//					prev = prev *10+dig;
//				}else {
//					prev = dig;
//				}
//				maxOdd = Math.max(dig,prev);
//			}else{
//				prev=0;
//			}
//			
//		}
//		System.out.println(maxOdd);
    }
	public static void main(String[] args) {
		String s = "2221";//"5103114";
		System.out.println(maxOdd(s));

	}

}
