package com.py.revision.sorting;

import java.util.*;

public class R04_MergeSort {
    
    // private static void mergeSort(int arr[],int l,int r); // No we cannot prototype in java

    public static void main(String args[]){
        int arr[] = {3,2,1,4};
        int l=0;
        int r=arr.length-1;
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,l,r);
        System.out.println(Arrays.toString(arr));
    }
    private static void mergeSort(int arr[],int l,int r){  
        if(r>l){
            int mid = l + (r-l)/2; // avoid overflow
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
    private static void merge(int arr[] , int l,int mid,int r){
        int len1= mid-l+1, len2 = r-mid;
        int a1[] = new int[len1],a2[] = new int[len2];
        // constructing left subarray
        for(int i=l;i<l+len1;i++){
            a1[i-l]=arr[i];
        }
        for(int j=mid+1;j<1+mid+len2;j++){
            a2[j-(mid+1)]=arr[j];
        }
        // now merging to final array => arr
        int i=0,j=0;
        while(i<len1&&j<len2){
            arr[l++] = a1[i]<a2[j]?a1[i++]:a2[j++];
        }
        while(i<len1){
            arr[l++] = a1[i++];
        }
        while(j<len2){
            arr[l++]=a2[j++];
        }
    }
}
