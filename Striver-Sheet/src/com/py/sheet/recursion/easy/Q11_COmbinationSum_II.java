package com.py.sheet.recursion.easy;
import java.util.*;
public class Q11_COmbinationSum_II {
    public static List<List<Integer>> combinationSum2(int[] arr, int target) {
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
        }
    }

    public static void main(String ...args){
        int arr[]={1,2,2,2,3,3,};
        int target=4;
        System.out.println(combinationSum2(arr, target));
    }
}
