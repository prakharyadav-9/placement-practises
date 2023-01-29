package com.py.sheet.array.medium;

import java.util.HashMap;
import java.util.Map;

public class Q24_LongestSubsequence {

	// arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int N) {

	    Map<Integer,Integer> frequencyMap = new HashMap<>();
	    for(int ele: arr){
	        frequencyMap.put(ele, frequencyMap.getOrDefault(ele,0)+1);
	        /*
	            here we will store the elements and its frequency 
	        */
	    }
	    int maxConse=0; // will contain the maximum continous elements
	    for(int x: arr){
	        // first we will grab the first element 
	       /*
	            because for rest elements we will just skip it if its contigiouse
	            else we will consider counting
	       */
	       if(frequencyMap.get(x-1)==null){ // this grabs the first element of the contigious elements
	           int count =0;
	           int element=x; // taking this as seperate because 
	                          // we will update the element by one to get the contigious elments
	           while(frequencyMap.get(element) !=null){
	               count ++; // count of elements
	               element++; // next element 
	           }
	           maxConse  =  Math.max(maxConse,count);
	       }
	       
	    }
	    
	return maxConse;    
	
	}
//	{
//        HashMap<Integer,Integer> fmap = new HashMap<>();
//        for(int x:arr){
//            fmap.put(x,fmap.getOrDefault(x,0)+1);
//        }
//        int maxi=0;
//        //traverse the array 
//        for(int x: arr){
//        //find the first element of subsequence
//        //for the first element of subsequence,its previous number is not exist in map
//            if(fmap.containsKey(x-1)==false){
//	            int elem = x;
//	            //count the number of consecutive subsequene
//	            int count = 0;
//	            while(fmap.containsKey(elem)){
//	                count++;
//	                elem++;
//	            }
//	            if(count>maxi){
//	                maxi = count;
//	            }
//            }
//        }
//        return maxi;
//	}
	
	public static void main(String[] args) {
		// 6 6 2 3 1 4 1 5 6 2 8 7 4 2 1 3 4 5 9 6
		/*
		 * 1 - 3
		 * 2 - 3
		 * 3 - 2
		 * 4 - 3
		 * 5 - 2
		 * 6 - 4
		 * 7 - 1
		 * 8 - 1
		 * 9 - 1
		 */
		int arr[] ={1,3,5,6,7,8,9,10};// {6,6,2,3,1,4,1,5,6,2,8,7,4,2,1,3,4,5,9,6};// {1,3,5,6,7,8,9,10};//{1,9,3,10,4,20,2};//{2,6,1,9,4,5,3};
		System.out.println(findLongestConseqSubseq(arr,arr.length));

	}

}
