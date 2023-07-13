package com.py.potd.gfg._2023.Month07;

import java.util.*;

public class POTD_07_13 {
    public static void main(String...args){
        int arr[] = {1,1,2,5,5};//{2, 2, 5, 10, 1, 2, 10, 5, 10, 2};//{1,1,2,5,5};
        boolean equal = isFrequencyUnique(arr.length,arr);
        System.out.println(equal);
    }
    public static boolean isFrequencyUnique(int n, int[] arr) {
        // code here
        Map<Integer,Integer> m=new HashMap<>();
        for(int e:arr){
            m.put(e,(m.getOrDefault(e,0))+1);
        }
        Set<Integer> s= m.keySet(),freq=new HashSet<>();

        for(int v:s ){
            int f = m.get(v);
            if(freq.contains(f))
                return false;
            freq.add(f);
        }
        return true;
    }
}
