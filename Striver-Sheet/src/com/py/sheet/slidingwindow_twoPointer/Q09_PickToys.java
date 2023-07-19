package com.py.sheet.slidingwindow_twoPointer;

import java.util.*;

public class Q09_PickToys{
    public static void 
    main(String...args){
        String s="baaaaaaaab";//"abaccab";
        int max = -1;
        max=getMaxToys(s);
        System.out.println(max);
    }

    private static int getMaxToys(String s) {
        int max=1;
        int low=0,high=0,len=s.length();
        Map<Character,Integer> freq = new HashMap<>();
        while(high<len){
            // pick the toy
            char ch = s.charAt(high);
            if(freq.containsKey(ch)){
                freq.put(ch,freq.getOrDefault(ch,0)+1);
            }else{
                if(freq.size()<2){
                    freq.put(ch,1);
                }else{
                    // calculate win size
                    max=Math.max(max,(high-low));
                    while(freq.size()==2){
                        char lowToy=s.charAt(low);
                        int lowToyFreq = freq.get(lowToy);
                        if(lowToyFreq==1){
                            // remove that toy
                            freq.remove(lowToy);
                        }else{
                            freq.put(lowToy,lowToyFreq-1);
                        }
                        low++;
                    }
                }
            }
            high++;
        }
        max=Math.max(max,high-low);
        return max;
    }
    
}