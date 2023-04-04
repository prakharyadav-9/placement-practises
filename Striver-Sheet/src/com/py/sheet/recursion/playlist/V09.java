package com.py.sheet.recursion.playlist;

import java.util.*;

public class V09 {
    /*
     * with the given candidates number, make the sum upto target
     * 
     * note: each candidate may only be used <b>ONCE</b> in the combination.
     * note: the output should be in lexograhical sorted order 
     */
    static
    List<List<Integer>> combinationSum(int arr[], int target){
        /*
         * Approach :
         *  pick and check if the combination is possible or not
         */
        Arrays.sort(arr); // sort by ascending order
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> currentElems = new Stack<>();
        f(0,target,arr,currentElems,ans);
        return ans;
    }

    private static
    void f(int idx, int target,int arr[], List<Integer> currentElems, List<List<Integer>> ans){
        if(target ==0){
            // add into result
            ans.add(new ArrayList<>(currentElems)); // because we are removing the element after the checking.
            return;
        }
        for(int i=idx; i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1])
                continue;
            if(arr[idx]>target)
                break;
            currentElems.add(arr[i]);
            f(i+1,target-arr[i],arr, currentElems,ans);
            currentElems.remove(currentElems.size()-1);
            // f(i+1,target,arr, currentElems,ans);
        }
    }
    public static void main(String ...args){
        int arr[]= {10,1,2,7,6,1,5,};//{1,2,1,2,2,};//
        int target =8;//4;//
        List<List<Integer>> lists = combinationSum(arr,target);
        printList(lists);
    }
    static
    void printList(List<List<Integer>> lists){
        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }
}
