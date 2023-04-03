package com.py.sheet.weeklycontest.gfg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GFG_WC_03_19 {

	static
	public int minimumBeauty(int id[], int n){
        // Code Here.
        int minBeauty = 0;
        int min=Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>(n);
        for(int i:id){
            map.put(i,map.getOrDefault(i,0)+1);
            min =  min>i?i:min;
            max = max<i?i:max;
        }
        Set<Integer> set = null;
        System.out.println(map);
        System.out.println(min+" "+ max);
        System.out.println(set= new HashSet<>(map.keySet()));
        while(!map.isEmpty()) {
        	minBeauty=0;
        	for(Integer i:set) {
//        		if(map.isEmpty())
//        			break;
        		if(map.getOrDefault(i,0)!=0) {
        			map.put(i, map.get(i)-1);
        			minBeauty++;
        		}else {
        			map.remove(i);
//        			set.remove(i);
        		}
        	}
        	System.out.println("min beauty:: "+minBeauty);
        }
        
        return minBeauty;
    }
	public static void main(String[] args) {
		int arr[] = {4, 5, 6, 6, 7};//{5, 1, 3, 2, 2, 4, 3, 4, 1};
		System.out.println(minimumBeauty(arr, arr.length));
	}

}
