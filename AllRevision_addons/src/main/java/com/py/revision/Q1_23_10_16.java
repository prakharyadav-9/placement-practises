package com.py.revision;

public class Q1_23_10_16 {
    /*
     * 2nd largest number from array
     */

     public static void main(String ...args){
        int arr[] = {5,10,6,8,1,10,11,2,6,9,8,7,};
        int secL = secLargesArray(arr);
        System.out.println(secL);
     }
     static int secLargesArray(int arr[]){
        int secL = -99;
        int larg = -999;
        for(int e:arr){
            if(e>larg)
                larg =e;
        }
        for(int e:arr){
            if(e!=larg && e>secL)
                secL=e;
        }
        return secL;
     }

     /*
      * /**

Extending the second largest to kth largest
	Approach I used Sorting
*/
/**
	so he asked me to write sorting

     static void mergeSort(int arr[]){
        int start = 0;
        int end = arr.length;

     }

      private static  void mergeSort(int arr[] , int sIdx,int eInd ){
        // if(s)
      }
      */
}
