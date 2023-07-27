package com.py.sheet.array.hard;

import java.util.*;

public class Q28_CountInversions {
    public static void main(String[] args) {
        long arr[] = {2,4,1,3,5,};//{5,3,2,4,1};
        long inv = inversionCount(arr, arr.length);
        System.out.println(inv);
    }
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N){
        // Your Code Here
        long inversion=0,arrcpy[]=new long[arr.length];
        System.arraycopy(arr,0,arrcpy,0,arr.length);
        // System.out.println(Arrays.toString(arrcpy));
        inversion=mergeSortInversionCount(arrcpy,0,arr.length-1);
        // System.out.println(Arrays.toString(arrcpy));
        return inversion;
    }
    static
    private long mergeSortInversionCount(long arr[],int start,int end){
        int inv=0;
        if(start<end){
            int mid=start+ (end-start)/2;
            // System.out.println(mid);
            inv+=mergeSortInversionCount(arr,start,mid);
            inv+=mergeSortInversionCount(arr,mid+1,end);
            inv+=mergeHelper(arr,start,mid,end);
        }
        // System.out.println("inv: "+inv);
        return inv;
    }
    
    private static 
    long mergeHelper(long arr[],int start,int mid,int end){
       long inv=0;
       ArrayList<Long> t=new ArrayList<>();
       int i=start, j=mid+1;
       while(i<=mid&&j<=end){
           if(arr[i]<=arr[j]){
               t.add(arr[i]); i++;
           }else {
               // inversion
                inv+=(mid-i+1);
                t.add(arr[j]); j++;
           }
       }
       while(i<=mid){ t.add(arr[i++]);}
       while(j<=end){ t.add(arr[j++]);}
       for(i=start;i<=end;i++){ arr[i]=t.get(i-start);}
       return inv;
    }
}
