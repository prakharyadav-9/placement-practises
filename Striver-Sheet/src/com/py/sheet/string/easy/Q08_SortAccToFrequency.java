package com.py.sheet.string.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q08_SortAccToFrequency {

	/*
	 * 
	 * RIGHT Now Skipped
	 * 		waiting for HEAP
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer,Integer> map  = new HashMap<>();
		
		int t=sc.nextInt();
		while(t-->0) {
			int size = sc.nextInt();
			for(int i=0;i<size;i++) {
				int a = sc.nextInt();
				if(!map.containsKey(a)) {
					map.put(a,1);
				}else {
					map.put(a,map.get(a)+1);
				}
			}
			System.out.println();
			System.out.println(map);
			
		}
		sc.close();
	}

}
