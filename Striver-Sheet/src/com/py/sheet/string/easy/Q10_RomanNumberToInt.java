package com.py.sheet.string.easy;

import java.util.HashMap;
import java.util.Map;

public class Q10_RomanNumberToInt {

	static  public int romanToDecimalForward(String str) {
        // code here
		int num = 0;
		Map<Character,Integer> symbols = new HashMap<>(7);
		// initializing all symbols
		symbols.put('0',0);
		symbols.put('I',1);
		symbols.put('V',5);
		symbols.put('X',10);
		symbols.put('L',50);
		symbols.put('C',100);
		symbols.put('D',500);
		symbols.put('M',1000);
		
		// Now iterating over all characters
		int len = str.length(),last=len-1;
		/*
		 * forward Approach
		 */
		char ch,ch1;
		int i;
		for( i=0;i<len;) {
			if(!(symbols.containsKey(ch=str.charAt(i))
					&& symbols.containsKey(ch1=(i+1)<=last?str.charAt(i+1):'0'))) {
				return -1;
			}
			else {
				int first = symbols.get(ch);
				int sec = symbols.get(ch1);
				if(sec>first) {
					num +=(sec-first);
					i+=2;
				}else {
					num +=first;
					i+=1;
				}
			}
		}
		return num;
    }
	
	
	public static void main(String[] args) {
		String num="MMCCCXXXIX";//"CMXVII";//"MCDXXII";//"CMXVI";//"XXIII";
		System.out.println(romanToDecimalForward(num));
		System.out.println(romanToDecimalBackward(num));

	}

	static  public int romanToDecimalBackward(String str) {
        // code here
		int num = 0;
		Map<Character,Integer> symbols = new HashMap<>(7);
		// initializing all symbols
		symbols.put('0',0);
		symbols.put('I',1);
		symbols.put('V',5);
		symbols.put('X',10);
		symbols.put('L',50);
		symbols.put('C',100);
		symbols.put('D',500);
		symbols.put('M',1000);
		
		// Now iterating over all characters
		int len = str.length(),last=len-1;
		/*
		 * reverse Approach
		 */
		for(int i=last;i>=0;i--) {
			int first = symbols.get(str.charAt(i));
			int sec = symbols.get((i-1)>=0?str.charAt(i-1):'0');
			if(sec<first) {
				num+=(first-sec);
				i--;
			}else {
				num+=first;
			}
		}
		return num;
    }
	
	
}
