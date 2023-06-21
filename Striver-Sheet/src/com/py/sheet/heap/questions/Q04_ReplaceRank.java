package com.py.sheet.heap.questions;

import java.util.*;

public class Q04_ReplaceRank {
    
    public static void
    main(String args[]){
        int ar[] = {2 ,20 ,10, 3, 14, 16, 14,};//{2,2,1,6};//{20, 15, 26, 2, 98, 6};
        System.out.println(Arrays.toString(ar));    
        int ans[] = replaceWithRank(ar,ar.length);
        System.out.println(Arrays.toString(ans));
    }
    static int[] replaceWithRank(int arr[], int N) {
        // code here
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((a,b)-> a.getKey() - b.getKey());
        // heap contains an entry {element, idx}
        for(int i=0;i<N;i++){
            minHeap.add(Map.entry(arr[i],i));
        }
        // System.out.println(minHeap);
        // System.out.println("checking the sorts by poping::");
        int rank = 1;
        int prevEle =-1;
        while(minHeap.isEmpty()==false){
            // System.out.printf("{%s} ->",minHeap.poll());
            if(minHeap.peek().getKey()==prevEle){
                arr[minHeap.peek().getValue()] = rank-1;
            }else{
                arr[minHeap.peek().getValue()] = rank;
                rank++;
            }
            prevEle = minHeap.poll().getKey();
        }
        // System.out.println();
        return arr;
    }
}
