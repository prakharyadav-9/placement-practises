// package com.py.sheet.heap.revision;

// import java.util.*;

// public class D01_MaxSumCombination {
//     public static void
//     main(String...args){
//         /*
//          * Correct Output is 192, 189, 189, 188, 188, 188, 188, 186, 185, 185
//          */
//         Integer a []  ={59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};//{68,35};// {1, 4, 2, 3};//{3,2};//
//         Integer b [] = {59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};// {68,35} ;//{2, 5, 1, 6};//{1,4};//
//         int k=10;
//         List ans = maxCombinations(a.length, k, a, b) ;
//         System.out.println(ans);
//     }
//     private static List maxCombinations(int length, int k, Integer[] a, Integer[] b) {
//         D01_MaxSumCombination obj = new D01_MaxSumCombination();
//         ArrayList<Integer> al=new ArrayList<>(),bl=new ArrayList<>();
//         for(int i=0;i<length;i++){
//             al.add(a[i]);
//             bl.add(b[i]);
//         }
//         return obj.solve(al, bl, k);
//     }

//     public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
//         int N = A.size();
//         int a[] = getKDecendingOrderElements(A,C);
//         int b[]= getKDecendingOrderElements(B,C);
//         ArrayList<Integer> ans = new ArrayList<>();
//         Set<Pair> idxSet = new HashSet<>();
//         PriorityQueue<Triplet> maxpq = new PriorityQueue<>(C,(t1,t2)-> t2.sum - t1.sum);
//         maxpq.offer(new Triplet(a[0]+b[0],0,0));
//         idxSet.add(new Pair(0,0));
//         while(ans.size()<C){
//             Triplet curr = maxpq.poll();
//             int i=curr.idx1;
//             int j=curr.idx2;
//             ans.add(curr.sum);
//             Pair p1 = new Pair(i+1,j), p2 = new Pair(i,j+1);
//             if(p1.i<C && idxSet.contains(p1)==false){
//                 idxSet.add(p1);
//                 maxpq.offer(new Triplet(a[p1.i]+b[p1.j],p1.i,p1.j));
//             }
//             if(p2.j<C && idxSet.contains(p2)==false){
//                 maxpq.offer(new Triplet(a[p2.i]+b[p2.j],p2.i,p2.j));
//                 idxSet.add(p2);
//             }
//         }
//         return ans;
//     }
//     // should override compareable
//     private class Triplet {
//         int sum, idx1,idx2;
//         Triplet(int sum,int i,int j){
//             this.sum=sum;
//             idx1=i;
//             idx2=j;
//         }
//     }
//     private class Pair{
//         int i,j;
//         Pair(int i,int j){
//             this.i=i;
//             this.j=j;
//         }
//         @Override
//         public boolean equals(Object p){
//             if(p==this) return true;
//             if(!(p instanceof Pair)) return false;
//             Pair t=(Pair)p;
//             return (t.i==this.i && t.j==this.j) ;
//         }
//     }
    
//     private int[] getKDecendingOrderElements(ArrayList<Integer> list,int k){
//         int res[] = new int[k];
//         // make this result list into decending order 
//         PriorityQueue<Integer> minheap = new PriorityQueue<>();
//         for(int ele:list){
//             minheap.offer(ele);
//             if(minheap.size()>k)    minheap.poll();
//         }
//         int i=k-1;
//         while(minheap.isEmpty()==false) res[i--]=minheap.poll(); 
//         return res;
//     }
// }
