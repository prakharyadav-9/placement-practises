package com.py.sheet.heap.questions;

import java.util.*;

public class Q03_KthSmallesElement {
    
    public static void
    main(String...arrs){
        System.out.print("Kth Smallest Element:: ");
        int arr[] = {7, 10, 4 ,20 ,15,};//{7 ,10, 4 ,3 ,20 ,15,};
        int k = 4;//3;
        int smallest = kthSmallest(arr,0,arr.length,k);
        System.out.printf(" %d \n",smallest);
    }
    public static int kthSmallest(int[] arr, int l, int r, int k) { 
        //Your code here
        PriorityQueue<Integer> max = new PriorityQueue<>(k+1,Collections.reverseOrder());

        int smallest = arr[0];
        for(int i=l;i<r;i++){
            max.add(arr[i]);
            System.out.println(max);
            if(max.size()>k){
                int rem = max.poll();
                System.out.println("removed  == "+rem);
            }    
        }
        smallest = max.poll();
        return smallest;
    } 
}
