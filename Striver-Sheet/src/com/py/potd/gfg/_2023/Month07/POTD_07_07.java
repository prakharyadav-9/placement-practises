package com.py.potd.gfg._2023.Month07;

import java.util.*;

public class POTD_07_07{
    public static void 
    main(String...args){
        long arr1[]={1, 3, 5, 7,};
        long arr2[]={0, 2, 6, 8, 9,};
        System.out.printf("Before mergning:\n%s & %s\n",Arrays.toString(arr1),Arrays.toString(arr2));
        merge(arr1,arr2,arr1.length,arr2.length);
        System.out.printf("After Merging:\n%s & %s\n",Arrays.toString(arr1),Arrays.toString(arr2));
    }
    /*
     * -> Declare 3 variables i to traverse arr1, j to traverse arr2 and k pointing to last index of arr1. 
     *      Initialize i with 0, j with 0 and k with n-1.
     * -> While i <= k && j < m i.e. any of the array is fully traversed, we check if arr1[i] is lesser than arr2[j] comes out to be true then increment i else, swap element present at kth index in arr1 and element at index j in arr2. It is because as both the arrays are sorted so if arr1[i] is greater than arr2[j] then arr2[j] is smaller from all the elements at ith index itself and onwards. So, it must be present in arr1. So, we swap arr2[j] with largest element in arr1 i.e. arr1[k]. Then, increment j by 1 and decrement k by 1 as this will be the greatest element in arr1.
     * -> When the loop ends, now sort both the arrays as the order of elements may not be in sorted manner. 
     *      But, it is certain that arr1 will contain smaller elements than elements present in arr2.
     */
    private static void
    swap(long arr1[],int idx1,long arr2[],int idx2){
        long temp = arr1[idx1];
        arr1[idx1]=arr2[idx2];
        arr2[idx2]=temp;
    }
    //Function to merge the arrays.
    public static void 
    merge(long arr1[], long arr2[], int n, int m) {
        // code here 
        int i=0,j=0,k=n-1;
        // put n smallest element in arr1
        // put m largest element in arr2
        while(i<=k&&j<m){
            if(arr1[i]>arr2[j]){
                swap(arr1,k,arr2,j);
                k--;
                j++;
            }else{
                i++;
            }
        }
        // now sort arr1 & arr2
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
