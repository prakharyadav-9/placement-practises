package com.py.mocks.bits.codeforces;

import java.util.*;

/*
 * didnt work
 * URL -> https://codeforces.com/group/5k7ui94Mwj/contest/448211/problem/B 
 */
public class Q02_MaximumProduct {
    public static void main(String...args){
        try(Scanner sc = new Scanner(System.in)){
            int t= sc.nextInt();
            while(t-->0){
                int n = sc.nextInt(); // length of test secquence
                int arr[]=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextInt();
                }
                long rmNum = maxProd(arr);
                System.out.println(""+rmNum);
            }
    

        }
    }

    private static class  Pair{
        int absNum,idx;
        Pair(int a,int b){
            this.absNum=a;
            this.idx=b;
        } 
        @Override
        public String toString(){
            return "{"+absNum+","+idx+"}";
        }
    }
    private static long maxProd(int[] arr) {
        PriorityQueue<Pair> max = new PriorityQueue<>(arr.length, (a,b)->b.absNum-a.absNum);
        for(int i=0;i<arr.length;i++){
            max.offer(new Pair(Math.abs(arr[i]),i));
        }
        int lastNeg=-1;
        int choose=5;
        long mul=1;
        for(int i=0;max.size()!=0;i++){
            Pair ele =max.poll();
            int idx = ele.idx;
            if(choose>0){
                choose--;
                mul*=arr[idx];
                if(arr[idx]<0){
                    lastNeg=idx;
                }
            }else{
                mul = Math.max(arr[idx]*mul/arr[lastNeg],mul);
            }
        }
        return mul;
    }
}
