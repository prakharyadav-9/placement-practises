package com.py.sheet.recursion.playlist;

import java.util.*;

public class V10_SubsetSum_1 {
    /*
     * subset sum
     */
    static
    ArrayList<Integer> subsetSums(List<Integer> arr, int N){
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Collections.sort(arr);
        res.add(0);
        f(0,N,0,arr,res);
        
        return res;
    }
    static
    void f(int idx,int size,int sum,List<Integer> arr,ArrayList<Integer> res ){
        res.add((sum+arr.get(idx)));
        if(idx==size-1){
            return;
        }
        // res.add(arr.get(idx));
        if(idx+1<size){
            // not taken
            f(idx+1,size,sum,arr,res);
            // taken
            f(idx+1,size, sum+arr.get(idx),arr,res);
        }
    }

    public static void main(String ... args){
        Integer arr[] = {3,1,2,};//{2,3,};
        Arrays.sort(arr);
        System.out.println(subsetSums(Arrays.asList(arr), arr.length));
    }
}
