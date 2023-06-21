package com.py.sheet.heap.questions;

import java.util.*;

public class Q01_MergeKSortedArrays_1 {
    public static void
    main(String args[]){
        int arr[][] ={{1,2,3,4},{2,2,3,4},
         {5,5,6,6},{7,8,9,9}};//{{1,2,3},{4,5,6},{7,8,9}};
        int k=arr[0].length;
        System.out.printf("Merging %d sorted Arrays \n:: ",k);
        List ans = mergeKArrays(arr,k);
        System.out.printf("\n Ans=> %s\n",ans);
    }

    /*
     * Using Priority Queue
     * T.C = O(K*K*LogK)
     */
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>(k*k);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int innerArr[]:arr){
            for(int ele: innerArr){
                min.add(ele);
            }
        }
        for(int i=0;i<k*k;i++){
            ans.add(min.poll());
        }
        return ans;
    }
}
