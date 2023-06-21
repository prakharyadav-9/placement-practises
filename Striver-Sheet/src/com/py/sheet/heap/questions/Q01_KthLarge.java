package com.py.sheet.heap.questions;

import java.util.*;

public class Q01_KthLarge {
    public static void
    main(String...args){
        // System.out.println("Kth largest element;;;");
        Integer arr[] = {7,10,4,3,20,15,};
        Integer k= 3;
        System.out.println(Arrays.toString(arr));
        Integer kthSmallest = getKthSmallestElement(arr,k);
        System.out.println("Kth smallest = "+kthSmallest);
    }

    private static
    Integer getKthSmallestElement(Integer arr[],Integer k){
        Integer ans = arr[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k+1,Comparator.reverseOrder());
        for(Integer ele:arr){
            insertIntoHeap(maxHeap,ele,k);
        }
        ans = maxHeap.peek();
        return ans;
    }
    private static
    void insertIntoHeap(PriorityQueue<Integer> heap,int ele,int k){
        heap.add(ele);
        if(heap.size()>k)
            heap.remove();
    }
}
