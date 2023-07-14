package com.py.sheet.slidingwindow_twoPointer;

import java.util.HashMap;
import java.util.Map;

public class Q05_MaxUniqueSubStr {
        int longestUniqueSubsttr(String S){
        Map<Character,Integer> freq = new HashMap<>();
        // from my prev codes i stands for low, and j = high
        int maxSubArray=0,i=0,j=0,len=S.length();
        for(;j<len;j++){
            char currCh=S.charAt(j);
            // do calculation, store frequency
            int chFreq=freq.getOrDefault(currCh,0);
            freq.put(currCh,chFreq+1); // increment ch freq
            if(chFreq==0){
                // first time adding then we can store the windown size
                maxSubArray=Math.max(maxSubArray,j-i+1); // max of prev win or current
            }else{
                // if previously we had some frequency, repeated
                // decrease freq of all continous lower character
                // until current character
                while(freq.get(currCh)>1){
                    char lowCh=S.charAt(i); // grab a prev character
                    freq.put(lowCh,freq.get(lowCh)-1); // decrease its freq
                    // then only move i (low)
                    i++;
                }
            }
        }
        return maxSubArray;
    }
}
