package com.py.sheet.heap.questions;

import java.util.*;

public class Q01_MergeKSortedArrays_2 {
    public static void
    main(String args[]){
        int arr[][] ={{1,2,3,4},{2,2,3,4},
         {5,5,6,6},{7,8,9,9}};//{{1,2,3},{4,5,6},{7,8,9}};
        int k=arr[0].length;
        System.out.printf("Merging %d sorted Arrays \n:: ",k);
        List ans = mergeKArrays(arr,k);
        System.out.printf("\n Ans=> %s\n",ans);
    }

    private static class entry{
        Integer value;
        Integer arrayThIdx;
        Integer valueThIdx;
        entry(int value,int ai,int vi){
            this.value=value;
            this.arrayThIdx = ai;
            this.valueThIdx = vi;
        }
        @Override
        public String toString(){
            return "["+value+","+arrayThIdx+","+valueThIdx+"]";
        }
    }
    /*
     * Using Priority Queue
     * T.C = O(KlogK)
     */
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>(k*k);
        // <value, arrayth Idx, corresponding value Idx in array>
        PriorityQueue<entry> min = new PriorityQueue<>((a,b)-> a.value - b.value);
        for(int i=0;i<arr.length;i++){
            min.add(new entry(arr[i][0],i,0));
        }
        // now we have min heap holding the minimum value at top
        // extract form top till heap becomes empty
        while(!min.isEmpty()){
            entry curr = min.poll();
            ans.add(curr.value);
            int arraythIdx = curr.arrayThIdx;
            int valuethIdx = curr.valueThIdx;
            // if we have not reached the till the end of each subarray add it to heap
            if(valuethIdx<k-1){
                min.add(new entry(arr[arraythIdx][valuethIdx+1],
                                                    arraythIdx,valuethIdx+1));
            }
        }
        return ans;
    }
}
