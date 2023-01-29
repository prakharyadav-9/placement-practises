package com.py.sheet.array.medium;

import java.util.ArrayList;
import java.util.Collections;

public class Q22_FindLeaders {

	static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> result= new ArrayList<>(n);
        result.add(arr[n-1]);
        if(n<=1)
        	return result;
        int currentMax= arr[n-1];
        for(int i=n-2;i>=0;i-- ) {
        	if(arr[i]>=currentMax) {
        		result.add(currentMax= arr[i]);
        	}
        }
        Collections.reverse(result);
        return result;
        
        
         // nive solution
        /*
         * T.C. = O(n^2)
         */
//        for(int i=0;i<n-1;i++) {
//        	boolean leader=true;        	
//        	for(int j=i+1;j<n;j++) {
//        		if(arr[i]-arr[j]< 0) {
//        			leader=false;
//        			break;
//        		}
//        	}
//        	if(leader) {
//        		result.add(arr[i]);
//        	}
//        }
//        result.add(arr[n-1]);
//		return result;
    }
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,4,0};//{16,17,4,3,5,2};
		System.out.println(leaders(arr,arr.length));

	}

}
