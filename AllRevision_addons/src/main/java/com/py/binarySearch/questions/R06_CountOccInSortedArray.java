package com.py.binarySearch.questions;

public class R06_CountOccInSortedArray {
    /*
     * Link:
     *  https://www.codingninjas.com/studio/problems/occurrence-of-x-in-a-sorted-array_630456
     * 
     */
    public static void main(String args[]){
        int arr [] = {1, 8, 12, 15, 17, 17, 18, 18, 18, 18 ,19};
        int x = 18;
        int count = count(arr,arr.length,x);
        System.out.println(count);
    }
    public static int count(int arr[], int n, int x) {
        //Your code goes here
        int fO = getFirstOcc(arr,x);
        if(fO==-1) return 0;
        int lO = getLastOcc(arr,x);
        return lO-fO+1;
    }
    private static int getFirstOcc(int arr[],int x){
        int idx=-1;
        int l=0,h=arr.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(x<=arr[mid]){
                h = mid-1;
                if(x==arr[mid]) idx=mid;
            }else{
                l=mid+1;
            }
        }
        return idx;
    }
    private static int getLastOcc(int arr[],int x){
        int idx=-1;
        int l=0,h=arr.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]<=x){
                l=mid+1;
                if(arr[mid]==x) idx=mid;
            }else h=mid-1;
        }
        return idx;
    }
}
