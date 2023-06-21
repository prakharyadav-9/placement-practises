package com.py.sheet.heap.questions;
import java.util.*;
public class Q05_TaskScheduler {
    
    public static void 
    main(String args[]){
        char arr[] = {'A','A','A','B','B','B'};//{'A', 'A', 'A', 'B', 'B', 'C','C'};
        int k = 2;

        System.out.println(leastInterval(arr.length,k,arr));
    }
    static 
    int leastInterval(int N, int K, char tasks[]) {
        // code here
        int time= 0;
        int arr[] = new int[26];
        // max heap to schedule maximum frequence first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        // put each characters into map and a count
        for(char ch:tasks){
            arr[ch-'A']++;
        }
        // put the counts into heap
        for(Integer it: arr ){
            if(it>0){
                maxHeap.add(-it);
            }
        }
        // System.out.println(maxHeap);
        // System.out.println(maxHeap.peek());
        // queue is required to maintain the current done task
        // & put to when its going to be available
        Queue<Map.Entry<Integer,Integer>> reschedules = new LinkedList<>();
        while(maxHeap.isEmpty()==false||reschedules.isEmpty()==false){
            // consume the current activity
            time++;
            if(maxHeap.isEmpty() == false){
                Integer currTask = maxHeap.poll() +1;
                if(currTask!=0){
                    // add to queue due to remaining frequency
                    reschedules.add(Map.entry(currTask,time+K));
                }
            }
            if(!reschedules.isEmpty() && reschedules.peek().getValue()==time){
                maxHeap.add(reschedules.poll().getKey());
            }
            // System.out.println(time);
        }
        return time;
    }
}
