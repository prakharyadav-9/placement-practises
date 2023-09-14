package com.py.revision.sorting;

import java.util.*;

public class R02_SelectionSort {
    public static void main(String args[]){
        int arr[] = {2,3,0,-1,8,999,77};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr) {
        //Your code goes here
        selectionSort(arr,0,arr.length-1);
    }
    private static void selectionSort(int arr[],int start,int end){
        for(int i=start;i<arr.length-1;i++){
            int currMin = arr[i];
            for(int j=i+1;j<=end;j++){
                if(currMin>arr[j]){
                    int temp = currMin;
                    currMin=arr[j];
                    arr[j]=temp;
                }
            }   
            arr[i]=currMin;
        }
    }
}
