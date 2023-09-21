package com.py.binarySearch.learning;

public class L01_BinarySearch {
    
    public static void main(String args[]){
        int arr[] = {3,4,6,7,9,12,16,17};
        int n = arr.length;
        int x=17;
        int idxFound = binarySearchItr(arr, n, x);
        System.out.println(idxFound);
        x=-1;        
        idxFound = binarySearchRec(arr, 0, n-1, x);
        System.out.println(idxFound);
    }
    /*
     * returns the index where the element if present 
     *      else return -1
     */
    private static int binarySearchItr(int arr[],int n,int x){
        int low=0, high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x) return mid;
            else if( arr[mid]<x){
                low=1+mid;
            }else{
                high =mid-1;
            }
        }
        return -1;
    }

    private static int binarySearchRec(int arr[],int low,int high,int x){
        if(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x) return mid;
            else if(arr[mid]<x)
                return binarySearchRec(arr, 1+mid, high, x);
            else
                return binarySearchRec(arr, low, mid-1, x); // this case tells the when we need to search left of mid
        }
        return -1;
    }
}
