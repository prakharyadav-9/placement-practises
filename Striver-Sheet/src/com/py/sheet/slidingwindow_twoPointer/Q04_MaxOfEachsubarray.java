package com.py.sheet.slidingwindow_twoPointer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q04_MaxOfEachsubarray {
     //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k){
        // Your code here
        Deque<Integer> potentialMax = new ArrayDeque<>();
        int high=0,low=0;
        ArrayList<Integer> result= new ArrayList<>();
        
        while(high<n){
            // do operation with high
            while(potentialMax.isEmpty()==false
                    && potentialMax.peekLast()<arr[high]){
                            potentialMax.pollLast(); // rm multiple elements
            } // remove all previous elements that are less than current high
            // then add the high 
            potentialMax.add(arr[high]);
            int winSz = high-low+1;
            if(winSz==k){
                // take the ans out
                result.add(potentialMax.peekFirst());
                // move the window with low
                if(potentialMax.peekFirst()==arr[low]){
                    // need to remove low form queue its gonna be out of window
                    potentialMax.pollFirst(); // removes only one element
                }
                low++;
            }
            // eventually move the window for both cases winSz equal or not eauql k
            high++;
        }
        return result;
    }
}
