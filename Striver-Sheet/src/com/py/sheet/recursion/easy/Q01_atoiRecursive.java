package com.py.sheet.recursion.easy;

public class Q01_atoiRecursive {

//	static
//	 int atoi(String str) {
//			// Your code here
//			int idx=0;
//			if(str.charAt(0)=='-' )
//			    return -1*atoi(str.substring(1),idx=1);
//			else if(str.charAt(0)== '+')
//			    return atoi(str.substring(1),idx=1);
//			return atoi(str,idx);
//		}
//	 
//		static
//		private
//		int atoi(String str,int idx){
//		    if(str.equals("") || idx==str.length()-1)
//	    	    return str.charAt(idx) - '0';
//	    	return (10*atoi(str,idx+1) + );
//		}
	public static void main(String[] args) {
		String num = "-1234";
		int numb = aToi(num);
		System.out.printf("intervalue of %s is %d",num,numb);

	}

	private static int aToi(String num) {
		int idx=num.length();
		if(num.charAt(0)=='-') {
			return -1* atoi1(num.substring(1),idx-1);
	}
		if( num.charAt(0)=='+')
			return atoi1(num.substring(1),idx-1);
		return atoi1(num,idx);
	}

	
	
	private static int atoi1(String str,int n) {
		// If str is NULL or str contains non-numeric
	    // characters then return 0 as the number is not
	    // valid
	    if (str == "" || !str.matches("^\\d*$")) {
	        return 0;
	    }
	    // Base case (Only one digit)
	    if (n == 1)
	    {
	        return str.charAt(0) - '0';
	    }
	     
	    // If more than 1 digits, recur for (n-1),
	    // multiply result with 10 and add last digit
	    return (10 * atoi1(str, n - 1) +
	                      str.charAt(n - 1) - '0');
	}

}
