package com.py.sheet.string.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q08_SortAccToFrequency {

	private static class pair{
        int item,freq;
        pair(int i,int f){item=i;freq=f;}
    }
	public static void main (String[] args){
       //code
       Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Map<Integer,Integer> freq=new HashMap<>();
            PriorityQueue<pair>pq=new PriorityQueue<>(n,(a,b)->{ 
                if(a.freq==b.freq)
                    return a.item-b.item;
                return b.freq-a.freq; 
            });
            for(int i=0;i<n;i++){
                int ip=sc.nextInt();
                int freqIp= freq.getOrDefault(ip,0);
                freq.put(ip,freqIp+1);
            }
            freq.forEach((k,v) -> {
                // System.out.println("key: " + k + ", value: " + v);
                pq.offer(new pair(k,v));
            });
            while(pq.isEmpty()==false){
                pair e=pq.poll();
                while(e.freq-->0)
                    System.out.printf("%d ",e.item);
            }
            System.out.println();
        }
		sc.close();
	}

}
