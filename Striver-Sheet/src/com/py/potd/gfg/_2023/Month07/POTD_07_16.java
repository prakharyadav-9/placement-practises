package com.py.potd.gfg._2023.Month07;

import java.util.LinkedList;
import java.util.Queue;

public class POTD_07_16 {
     //Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q){
        //add code here.
        LinkedList<Integer> revQ = new LinkedList<>();
        while(!q.isEmpty()){
            revQ.addFirst(q.poll());
        }
        return revQ;
    }
}
