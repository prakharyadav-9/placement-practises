package com.py.binarySearch.questions;

import java.util.*;

public class R04_CeilFloor {
    
    /*
     * Link: https://practice.geeksforgeeks.org/problems/ceil-the-floor2802/1 
     */
    public static void main(String[]args){
        int []arr={5,6,8,9,6,5,5,6};
        int x=7;
        Pair p = new R04_CeilFloor().getFloorAndCeil(arr, arr.length, x);
        System.out.println(p.f + " "+ p.c);
    }

    private class Pair{
        int f,c;
        Pair(){
            this.f=this.c=0;
        }
        Pair(int f,int c){
            this.f=f;
            this.c=c;
        }
    }
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here
        Pair fc = new Pair(-1, -1);
        Arrays.sort(arr); // sort the array
        fc.f = floor(arr,n,x);
        fc.c = ceil(arr, n, x);
        return fc;
    }
    private int floor(int arr[], int n, int x){
        int f=-1;
        int l=0,h=n-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid]<=x){
                f=arr[mid];
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return f;
    }
    private int ceil(int arr[],int n,int x){
        int c=-1;
        int l=0,h=n-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid]>=x){
                c=arr[mid];
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return c;
    }
}
