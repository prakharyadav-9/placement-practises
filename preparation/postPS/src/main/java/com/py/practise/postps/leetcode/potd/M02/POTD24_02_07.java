package com.py.practise.postps.leetcode.potd.M02;

import java.util.*;

class POTD24_02_07{
    private class pair{
        char ch;
        int freq;
        pair(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }
        @Override
        public String toString(){
            return "{"+ch+","+freq+"}";
        }
    }
    public String frequencySort(String s) {
        List<pair> orderedList = new ArrayList<>(); // needed to sort the characters
        Map<Character,pair> freqMap = new HashMap<>();
        StringBuilder sortedS = new StringBuilder();
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(freqMap.containsKey(ch)){
                pair p =freqMap.get(ch);
                p.freq++; // incrementing the frequency 
            }else{
                pair p = new pair(ch,1); // adding the element first time
                orderedList.add(p);
                freqMap.put(ch,p);
            }
        }
        Collections.sort(orderedList,(a,b)->b.freq - a.freq); // sorting in decending order
        while(true!=orderedList.isEmpty()){
            pair p = orderedList.remove(0); // removes the first element
            while(0!=p.freq--){
                sortedS.append(p.ch); // adding the character according to frequency
            }
        }
        return sortedS.toString();
    }
}