package com.py.sheet.heap.questions;
import java.util.*;
public class Q09_Sort_KSortedArray {
    /*
     * URL: https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Heap/video/MTM5MA%3D%3D 
     */
    public static void
    main(String args[]){
        int arr[] = {9,8,7,18,19,17,20,23,22,21,28,27,26};
        int k=2;
        System.out.println(Arrays.toString(arr));
        sortKSorted(arr,k);
        System.out.println(Arrays.toString(arr));
    }
    public static void 
    sortKSorted(int arr[],int k){
        int lim = k;//2*k+1;
        PriorityQueue<Integer> minHeap
                    =new PriorityQueue<>(lim);
        int idx=0;
        for(int i=0;i<arr.length;i++){
            minHeap.offer(arr[i]);
            if(minHeap.size()>lim){
                arr[idx++]=minHeap.poll();
            }
        }
        // System.out.println(minHeap.size());
        while(minHeap.isEmpty()==false){
            arr[idx++]=minHeap.poll();
        }
    }
}
