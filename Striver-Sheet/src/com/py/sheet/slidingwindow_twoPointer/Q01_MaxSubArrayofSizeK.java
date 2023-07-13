package com.py.sheet.slidingwindow_twoPointer;

import java.util.*;
import com.py.util.*;

public class Q01_MaxSubArrayofSizeK {
    public static void 
    main(String...args){
        Integer arr[]= {100, 200, 300, 400};
        int k=2;
        long maxSum = -1;
        Q01_MaxSubArrayofSizeK obj = new Q01_MaxSubArrayofSizeK(); 
        maxSum=obj.maximumSumSubarray(k,arr,arr.length);
        ArrayList<Integer> Arr = new ArrayList<>();
        Arr = Util.arrayToList(arr);
        System.out.println(maxSum);
        maxSum=maximumSumSubarray(k,Arr,Arr.size());
        System.out.println(maxSum);
        
    }
    public long maximumSumSubarray(int K, Integer[] Arr,int N){
        long maxSum=0;
        // two pointer approach
        int i=0, j=0;
        for(;i<K;i++){
            maxSum+=Arr[i];
        }
        for(;i<N;i++){
            long currSum =maxSum;
            currSum+=Arr[i];
            currSum-=Arr[j++];
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;   
    }
    static long maximumSumSubarray(int K, 
                    ArrayList<Integer> Arr,int N){
        // code here
        long maxSum=Integer.MIN_VALUE,currSum=0;
        int i=0,j=0;
        for(;i<K;i++)   currSum+=Arr.get(i);
        while(i<N){
            maxSum=Math.max(maxSum,currSum);
            currSum-=Arr.get(j++);
            currSum+=Arr.get(i++);
        }
        maxSum=Math.max(maxSum,currSum);
        return maxSum;
    }
}
