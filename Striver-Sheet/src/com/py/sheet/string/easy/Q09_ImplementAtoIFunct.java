package com.py.sheet.string.easy;

public class Q09_ImplementAtoIFunct {

	static
	int atoi(String str) {
		// Your code here
		int number=0;;
		int i;
		int digits = str.length();
		for(i=(str.charAt(0)=='-'||str.charAt(0)=='+')?1:0;i<digits;i++) {
			char digit = str.charAt(i);
			if(digit>='0' && digit<='9') {
				number = number*10 + (digit-'0');
			}else {
				return -1;
			}
		}
		if(str.charAt(0)=='-') {
			return -number;
		}
		return number;
	}
	public static void main(String[] args) {
		String num = "12";
		System.out.println(atoi(num));
		System.out.println(Integer.parseInt(num,16));
	}

}
