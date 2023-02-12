package com.py.sheet.weeklycontest.gfg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WC_02_12 {
 
	static boolean goodJump(int arr[], int idx){
        if(arr[idx]%2==0 || arr[idx] %3==0){
            return true;
        }
        
        return false;
    }
    static int minJump(int arr[], int n){

    	/*
    	 * using BINARY SEARCH 
    	 * 	COMPLETE IT
    	 */
    	
//    	  int l=0;
//        int h=n-1;
//        int ans=1;
//        while(l<h){
//            int mid = l+(h-l)/2;
//            if(goodJump(arr, mid)){ // if it is good jump or not
//                ans+=1;
//                l=mid+1;
//            }else{
//                // h-=1;
//                h-=1;
//            }
//        }
//        return ans;
    	
    	
    	Set<Integer>  goodjumps = new HashSet<>(arr.length);
    	int ans=1;
    	for(int i=0;i<n;i++) {
    		if(goodJump(arr,i)) {
    			goodjumps.add(i);
    		}
    	}
    	Integer goodIdxs[] = new Integer[goodjumps.size()]; 
    	goodjumps.toArray(goodIdxs);
    	System.out.println(Arrays.toString(goodIdxs));
    	for(int i=1;i<goodIdxs.length;i++) {
    		ans = Math.max(ans,Math.abs(goodIdxs[i]-goodIdxs[i-1]));
    	}
    	return ans;
    }
	public static void main(String[] args) {
		int arr[] ={2,1,3,6};//{2,5,7,9,15,17,27};//
		int N=1;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int arr1[] = new int[N];
		for(int i=0;i<N;i++) {
			arr1[i]=sc.nextInt();
		}
		System.out.println(minJump(arr1,arr1.length));
	}

}
