package com.py.tests.samsung;

public class Q2_NumOfUniqueEleInSubArray {
    
    /*
     * find the total number of unique elements in all
     * subarrays of size k 
     * if no unique elements in subarray possible return -1;
     */
    public static void main(String [] args){
        int arr[] = {1,2,3,1,1,5};
        int n = arr.length;
        int k=3;
        int uniq = countUniqueElements(arr, n,k);
        System.out.println(uniq);
    }
    static int countUniqueElements(int arr[], int n,int k){
        int uniq = -1;

        return uniq;
    }
}
