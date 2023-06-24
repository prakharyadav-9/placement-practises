package com.py.sheet.heap.questions;

import java.util.*;

public class Q08_MaxSumCombination {
    public static void 
    main(String...args){
        int a []  = {1, 4, 2, 3};//{3,2};//
        int b [] =   {2, 5, 1, 6};//{1,4};//
        int k=3;
        List ans = maxCombinations(a.length, k, a, b) ;
        System.out.println(ans);
    }
    static 
    List<Integer> maxCombinations(int n, int k, int a[], int b[]) {
        // code here
        List<Integer> ans =new ArrayList<>();
        // make priority queue of size k
        // min heap
        PriorityQueue<Integer> minA=  new PriorityQueue<>(n+1);
        PriorityQueue<Integer> minB= new PriorityQueue<>(n+1);
        for(int i=0;i<n;i++){
            minA.add(a[i]);
            minB.add(b[i]);
            if(minA.size()>k){
                minA.poll();
                minB.poll();
            }
        }
        int aa[] = new int[n];
        int bb[] = new int [n];
        for(int i=k-1;i>=0;i--){
            aa[i]=minA.poll();
            bb[i]=minB.poll();
        }
        // priority queue maintains the maximum elements
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        // set maintains the existing/done indexs
        Set<Pair> idxPairs = new HashSet<>();
        
        // initializing
        pq.add(new Triplet(aa[0]+bb[0],0,0));
        idxPairs.add(new Pair(0,0));
        while((ans.size()<k)){
            Triplet curr = pq.poll();
            int i=curr.i;
            int j=curr.j;
            ans.add(curr.sum);
            Pair p1=new Pair(i+1,j);
            Pair p2=new Pair(i,j+1);
            if(i+1<k &&!(idxPairs.contains(p1))){
                idxPairs.add(p1);
                pq.add(new Triplet(aa[i+1]+bb[j],i+1,j));
            }
            if(j+1<k&&!(idxPairs.contains(p2))){
                idxPairs.add(p2);
                pq.add(new Triplet(aa[i]+bb[j+1],i,j+1));
            }
        }
        return ans;
    }

    private static
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
        @Override
        public boolean equals(Object p){
            if(p==this) return true;
            if(!(p instanceof Pair))    return false;
            Pair test = (Pair)p;
            return this.i==test.i && this.j==test.j;

        }
    }
    private static 
    class Triplet implements Comparable<Triplet>{
        int sum;
        int i;
        int j;
        Triplet(int sum,int i,int j){
            this.sum=sum;
            this.i=i;
            this.j=j;
        }
        @Override
        public int compareTo(Triplet o) {
            // want to implemtn a max heap
            return o.sum - this.sum;            
        }
    }
    
}
