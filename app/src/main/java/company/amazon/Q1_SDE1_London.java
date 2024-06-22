package company.amazon;

import java.util.*;

class Q1_SDE1_London{
    /*
     * Amazon OA SDE 1 London: https://www.desiqna.in/13428/amazon-oa-sde1-london-may-2023-set-131
     *
     * Pair of Pairs
     * given Q pairs in the form of (L,R) where all L values are pairwise distinct from each other and
     * an array of size N.
     *
     * find out the total numbers of pairs (i,j) where i<j and (A[i],A[j]) should be equal to exactly
     * one of the given Q pairs.
     *
     * constraints  :
     *  1<=N<=100000
     *  1<=Q<=100000
     *  1<=A[i]<=100000
     */

    private static class Pair{
        Integer L,R;
        Pair(int L,int R){
            this.L=L;
            this.R=R;
        }
    }

    public static void main(String[] args){
        Pair[] pairs = {
                new Pair(4,4),
//                new Pair(10,5),
//                new Pair(5,4),
            };

        int[] arr = {4,4,10,5,4,10,5,};
        int validPairs = getValidPairs(pairs,arr);
        System.out.println(validPairs);
    }

    private static int getValidPairs(Pair[] paris, int[] arr){
        int count=0;
        Map<Integer,Integer> parents = getParents(paris);
        Map<Integer,Integer> freq = new HashMap<>(arr.length);
        for(int e:arr){
            count = count + freq.getOrDefault(e,0);
            if(parents.containsKey(e)){
                int parent = parents.get(e);
                freq.put(parent,1+freq.getOrDefault(parent,0));
            }
        }
        return count;
    }
    @SuppressWarnings("unchecked")
    static <K,V,T extends Pair> Map<K,V> getParents(T[] pairs){
        Map<K,V> parent  = new HashMap<K,V>();
        for(T pair:pairs){
            parent.put((K) pair.L, (V) pair.R);
        }
        return parent;
    }
}