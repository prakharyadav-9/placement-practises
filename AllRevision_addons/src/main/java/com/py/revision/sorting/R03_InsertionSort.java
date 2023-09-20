package com.py.revision.sorting;

import java.util.*;

public class R03_InsertionSort {
    
    public static void main(String args[]){
        int arr[] = {2,3,5,-2,99,8,1};
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        insertionSort(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertionSort(int[] arr, int size) {
        //Your code goes here
        for(int i=1;i<size;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && key<arr[j]){
                arr[j+1]=arr[j]; // shifting
                j--;
            }
            // now j reaches either -1 or points to the element where 
            // arr[j] < key
            // therefore we need to put the key into (j+1)th idx 
            arr[j+1]=key;
        }
    }
}
