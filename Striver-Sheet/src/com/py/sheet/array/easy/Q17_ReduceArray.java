package com.py.sheet.array.easy;

import java.util.*;

public class Q17_ReduceArray {
    public static void
    main(String args[]){
        int arr[] = {10, 40, 20,};

        System.out.println(Arrays.toString(arr));
        convert(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        
    }
    static private class Pair{
        int num,idx;
        Pair(int num,int idx){
            this.num=num;
            this.idx=idx;
        }
    }
    static 
    void convert(int[] arr, int n) {
        //Code here
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(n, (a,b)-> a.num - b.num);
        for(int i=0;i<n;i++){
            minHeap.offer(new Pair(arr[i],i));
        }
        int i=0;
        while(minHeap.isEmpty() == false){
            Pair p = minHeap.poll();
            arr[i++] = p.idx;
        }
    }
}
