package com.py.sheet.bitManupilation.learning;

import java.util.*;

public class L07_PeterAndLock {
    /*
        Peter and lock problem:
            https://codeforces.com/problemset/problem/1097/B 

            I want all possible anwers
     */

    private static
    void f(int idx, int arr[], int currSum, List<Integer> elems,List<List<Integer>> res){
        if(idx == arr.length && (currSum%360) == 0){
            res.add(new ArrayList<>(elems));
            return;
        }
        if(idx<arr.length){
            // taking possitive
            elems.add(arr[idx]);
            f(idx+1,arr,(currSum+arr[idx])%360,elems,res);
            elems.remove(elems.size()-1);
            elems.add((-1)*arr[idx]);
            f(idx+1,arr,(currSum-arr[idx])%360,elems,res);
            elems.remove(elems.size()-1);
        }
    }

    static
    List<List<Integer>> peterAndLock(int arr[]){
        List<List<Integer>> res = new ArrayList<>();
        f(0,arr,0,new ArrayList<>(),res);
        return res;
    }
     
    public static void main(String...args){
        int arr[] = {10,20,30}; //{270,270,270,};//{10,10,10,};//
        List<?> ans = peterAndLock(arr);
        if(!ans.isEmpty()){
            System.out.println(ans);
        }else{
            System.out.println("No Possible combinations :(");
        }
    }
}
