package com.py.practise.postps.leetcode.potd.M01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class POTD24_01_18{
    /*
     * URL: https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=daily-question&envId=2024-01-17 
     * 
     * given an array, state whether all elements possess unique frequency or not.
     */

     public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int ele: arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        Set<Integer> freq = new HashSet<>();
        for(int ele:arr){
            if(map.containsKey(ele)){
                if(freq.contains(map.get(ele)))
                    return false;
                else freq.add(map.get(ele));
                map.remove(ele);
            }
        }
        return true;
    }
}