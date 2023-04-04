package com.py.sheet.recursion.easy;

import java.util.*; 

public class Q10_CombinationSum {

    /*
     * unreliable procedure
     */
    // static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B){
    //     // add your code here
    //     Set<Integer> s = new HashSet<Integer>(A);
    //     A = new ArrayList<>(s);
    //     List<Integer> picked= new ArrayList<>();
    //     ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    //     Collections.sort(A);
    //     f(0, A, B, picked,res);
    //     return res; 
    // }
    // static void f(int idx,ArrayList<Integer> arr, int target, List<Integer> picked,ArrayList<ArrayList<Integer>> res){
    //     if(target==0){
    //         // System.out.println(picked);
    //         res.add(new ArrayList<>(picked));
    //         return;
    //     }
    //     if(arr.get(idx)<=target) // for current value at idx is greater than targ
    //     {
    //         picked.add(arr.get(idx));
    //         f(idx, arr, target-arr.get(idx), picked,res); // picking idx
    //         picked.remove(picked.size() -1);
    //     }
    //     if(idx+1<arr.size()){ // called only if further idx is possible
    //         f(idx+1, arr, target, picked,res); // not picking
    //     }
    // }

    public static void main(String...args){
        Integer arr[]={8 ,1 ,8 ,6 ,8};//{6,5,7,1,8,2,9,9,7,7,9};
        int sum = 12;
        System.out.println(combinationSum(new ArrayList<>((Arrays.asList(arr))),sum));
    }
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B){
        // add your code here
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        func(0, A,B,ans,new ArrayList<>());
        return ans;
    }
    private static void func(int idx, ArrayList<Integer> a, int target, ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> currentDS) {
        if(target==0){
            ans.add(new ArrayList<>(currentDS));
            return;
        }
        if(a.get(idx)<=target) // for current value at idx is greater than targ
        {
            int ele;
            currentDS.add(ele=a.get(idx));
            func(idx, a, target-ele,  ans,currentDS); // picking idx
            currentDS.remove(currentDS.size()-1);
        }
        if(idx+1<a.size()){ // called only if further idx is possible
            if(a.get(idx)!=a.get(idx+1))
                func(idx+1, a, target, ans,currentDS); // not picking
        }
    }
}
