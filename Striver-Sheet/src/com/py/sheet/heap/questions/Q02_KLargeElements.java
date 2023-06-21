package com.py.sheet.heap.questions;

import java.util.*;

public class Q02_KLargeElements {
    public static void 
    main(String args[]){
        int arr[] = {12,5,787,1,23,};
        int k =2;
        List res = kLargest(arr,arr.length,k);
        System.out.println(res);
    }

    public static ArrayList<Integer> kLargest(int arr[], int n, int k){
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k+1);
        for(int ele: arr){
            minHeap.offer(ele);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        for(int i=0;i<k;i++){
            ans.add(minHeap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}


