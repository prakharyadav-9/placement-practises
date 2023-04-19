package com.py.sheet.bitManupilation.learning;

import java.util.*;

public class L07_PowerSetAlgo{

    /*
     * Powerset Algorithm
     */

    private
    static 
    List<List<Integer>> powerSetAlgo(int arr[]){
        List<List<Integer>> res = new ArrayList<>();
        int subsets= (1<<arr.length);
        for(int num=0;num<subsets;num++){ 
            List<Integer> set = new ArrayList<>();
            for(int bit=0;bit<=(arr.length-1);bit++){
                if((num&(1<<bit)) !=0 ){
                    set.add(arr[bit]);
                }
            }
            res.add(set);
        }
        return res;
    } 

    public static void main(String...args){
        int arr[]={1,2,3};//{1,2,4,6,7,9,8,0}; //
        List<?> ans = powerSetAlgo(arr);
        System.out.println(ans);
    }
}