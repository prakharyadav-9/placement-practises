package com.py.sheet.recursion.playlist;

import java.lang.reflect.Array;
import java.util.*;


public class V11_SubsetSum_2 {
    /*
     * given array nums (may contain duplicates). 
     * return all possible subsets(the power set)
     * 
     * NOTE:: the solution set must not contain duplicate subsets.
     *          return soultion in any order.
     */
    
    private static ArrayList<ArrayList<Integer>> subSet(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        f(0,arr, ans, new ArrayList<>());
        return ans;
    }
    private static void f(int idx,int arr[], ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> currDS){
            ans.add(new ArrayList<>(currDS));
            for(int i=idx;i<arr.length;i++){
                if(i!=idx&& arr[i]==arr[i-1])
                    continue; // eliminating the duplicate posotioning calls
                currDS.add(arr[i]);
                f(i+1, arr, ans, currDS);
                currDS.remove(currDS.size()-1);
            }
    }

    public static void main(String ...args){
        int arr[]={1,2,3,};//{1,2,2,2,3,3,};//{1,2,2};//
        ArrayList ans=null;
        System.out.println(ans=subSet(arr));
        System.out.println(ans.size());
    }

}
