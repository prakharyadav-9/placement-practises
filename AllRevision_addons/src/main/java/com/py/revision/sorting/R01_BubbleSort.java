package com.py.revision.sorting;

import java.util.*;

public class R01_BubbleSort {
    /*
     * Implement bubble sort
     */
    public static void main(String []args){
        int arr[] = {3,2,7,1,-2,0,999};
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    /*
     * optimization in bubble sorting is that 
     * during any pass if there is no swapping, then the array must have been sorted
     * therefore no need for further swapping 
     * 
     * T.C. = O(N^2) 
     * S.C. = O(1)
     * 
     */
    public static void bubbleSort(int[] arr, int n) {
        //Your code goes here
        for(int pass=0;pass<n-1;pass++){
            boolean swapped=false;
            for(int i=0;i<n-1-pass;i++){
                // below if tells if we need to swap the elements or not
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                    swapped=true;
                }
            }
            if(swapped==false){
                break;
                // list is already sorted at this point
            }
        }
    }
    private static void swap(int arr[],int idx1,int idx2){
        arr[idx1]=arr[idx1]^arr[idx2];
        arr[idx2]=arr[idx1]^arr[idx2];
        arr[idx1]=arr[idx1]^arr[idx2];
    }
}
