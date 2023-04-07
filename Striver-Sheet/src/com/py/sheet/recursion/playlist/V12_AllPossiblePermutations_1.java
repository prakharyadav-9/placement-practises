package com.py.sheet.recursion.playlist;

import java.util.*;

public class V12_AllPossiblePermutations_1{
    /*
     * generate all permutations of array/String.
     *  in any order
     */
    static <K>
    List<List<K>> allPossiblePermutations(K []arr){
        List<List<K>> res = new ArrayList<>();
        Boolean map1[] = new Boolean[arr.length];
        Arrays.fill(map1, false);
        f( arr, new ArrayList<>(), res,map1);
        return res;
    }
    /*
     * current approach is initially the map is initialzed to false
     *  Map == indicates  
     *      false :: indicaating the element is available to be picked up
     *      true  :: the element cannot be picked up
     */
     
    private static  <K> void f( K arr[], List<K> currDS, List<List<K>> res, Boolean []map1){
        if(currDS.size() == arr.length){
            res.add(new ArrayList<>(currDS));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!map1[i]){
                currDS.add(arr[i]);
                map1[i]= true;
                f(arr, currDS, res,map1);
                map1[i]=false;
                currDS.remove(currDS.size()-1);
            }
        }
    }
    public static void main(String ...args){
        Integer arr[]= {,};
        String str[] = "abc".split("");
        List res=allPossiblePermutations(arr);
        System.out.println("List integers:: "+ res.toString());
        System.out.println(res.size());
    }
}