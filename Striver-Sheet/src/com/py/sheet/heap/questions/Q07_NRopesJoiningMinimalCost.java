package com.py.sheet.heap.questions;

import java.util.*;

public class Q07_NRopesJoiningMinimalCost {
    public static void
    main(String...args){
        long arr[] = {4, 2, 7, 6, 9};// {4, 3, 2, 6};
        long ans = minCost(arr,arr.length);
        System.out.println(ans);
    }
    //Function to return the minimum cost of connecting the ropes.
    static
    long minCost(long arr[], int n) {
        // your code here
        long ans=0l;
        PriorityQueue<Long> ropes = new PriorityQueue<>(n);
        for(long ele:arr)
            ropes.add(ele);
        // System.out.println(ropes);
        while(ropes.size()>1){
            long r1 = ropes.poll();
            long r2 = ropes.poll();
            ans+=(r1+r2);
            ropes.add(r1+r2);
            // System.out.println(ropes+" | "+ ans);
        }
        
        return ans;
    }
}
