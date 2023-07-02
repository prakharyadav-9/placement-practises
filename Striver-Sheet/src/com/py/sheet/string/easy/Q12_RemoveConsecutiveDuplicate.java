package com.py.sheet.string.easy;

import java.util.Stack;

public class Q12_RemoveConsecutiveDuplicate {
    public static void main(String args[]){
        String s = "aaabbaaccd";
        String reduced=null;
        reduced = removePair(s);
        System.out.println(reduced);


    }
    public static String removePair(String s) {
        // code here
        int len = s.length();
        StringBuilder reducedStr = new StringBuilder(len);
        // iterate the string
        reduce(0,s,len,reducedStr);
        if(reducedStr.length()==0)  return "-1";    
        return reducedStr.toString();
    }
    static
    private void reduce(int idx,String s,int len,StringBuilder rS){
        if(idx==len){
            return ;
        }
        int n = rS.length();
        char ch = s.charAt(idx);
        if(n==0 || rS.charAt(n-1)!=ch){
            rS.append(ch);
        }else{
            rS.deleteCharAt(n-1);
        }
        reduce(idx+1,s,len,rS);
    }
}
