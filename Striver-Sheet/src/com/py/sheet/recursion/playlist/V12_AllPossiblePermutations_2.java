package com.py.sheet.recursion.playlist;
import java.util.*;
public class V12_AllPossiblePermutations_2 {
    
    public static void main(String ...args){
        Integer arr[]= {1,2,3,4,};//{1,2,3,};
        String str[] = "abc".split("");
        List res=allPossiblePermutations_2(arr);
        System.out.println("List integers:: "+ res.toString());
        System.out.println(res.size());
    }
    private static <K> void swap(K arr[],int idx1, int idx2){
        K t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }
    private static List<List<Integer>> allPossiblePermutations_2(Integer[] arr) {
        List<List<Integer>> res = new LinkedList<>();
        f(0, arr, res);
        return res;
    }
    
    static void f(int idx, Integer []arr,List res){
        if(idx == arr.length){
            res.add(new ArrayList<Integer>(Arrays.asList(arr)));
            return;
        }
        for(int i=idx; i<arr.length;i++){
            swap(arr, idx, i);
            f(idx+1,arr,res);
            swap(arr, idx, i);
        }
        
    }
}
