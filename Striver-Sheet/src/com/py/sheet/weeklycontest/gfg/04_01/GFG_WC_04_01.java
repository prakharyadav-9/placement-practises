package com.py.sheet.weeklycontest.gfg

import java.util.Arrays;

.04_01;

public class GFG_WC_04_01 {

    static
    public long maximumSum(int A[], int n){
        // Code Here.
        long res=0;
        Arrays.sort(A);
        for(int i=0;i< A.length;i++){
            res+=((i+1)*1l*A[i]);
        }
        return res;
    }

   public static void main(String ...args) {
    int arr[]={2,3,5,0,};
    Arrays.sort(arr);
    System.out.println(maximumSum(arr, arr.length));
   }
}
