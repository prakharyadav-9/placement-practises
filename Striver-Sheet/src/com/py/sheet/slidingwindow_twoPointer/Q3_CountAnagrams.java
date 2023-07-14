package com.py.sheet.slidingwindow_twoPointer;

import java.util.*;

public class Q3_CountAnagrams{
    int search(String pat, String txt) {
        // code here
        Map<Character,Integer> freqMap = new HashMap<>();
        int patLen=pat.length(),txtLen=txt.length();
        for(int i=0;i<patLen;i++){
            char ch=pat.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        // now freqeuncy map is prepared
        int low=0,high=0,anagrams=0,count=freqMap.size();
        // we got to traverse the given txt
        while(high<txtLen){
            char ch=txt.charAt(high);
            // calcualtion with jth item
            if(freqMap.containsKey((ch))){
                int letterCounts=freqMap.get(ch);
                freqMap.put(ch,letterCounts-=1);
                if(letterCounts==0){
                    // one of the frequency is decreades to zero
                    count--; 
                }
            }
            int winSz = high-low+1;
            if(winSz<patLen){
                high++;
            }
            else if(winSz==patLen){
                // calculate answer
                if(count==0){ anagrams++; } // anagram detected
                // now slide the window
                char lowCh=txt.charAt(low);
                low++;
                high++;
                if(freqMap.containsKey(lowCh)){
                    // add the freqeuncy back to the map if valid
                    int lastCharCnt = -1; 
                    freqMap.put(lowCh,lastCharCnt=freqMap.get(lowCh)+1);
                    if(lastCharCnt==1) // last char again added to freq
                        count++;
                }
            }
        }
        return anagrams;
    }

    public static void main(String ...args){
        String txt = "aabaabaa";//"forxxorfxdofr";
        String pat ="aaba";//"for";
        Q3_CountAnagrams obj = new Q3_CountAnagrams();
        int anagrams=-1; 
        anagrams = obj.search(pat, txt);
        System.out.println(anagrams);
    }
}