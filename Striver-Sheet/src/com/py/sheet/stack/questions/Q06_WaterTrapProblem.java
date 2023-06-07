package com.py.sheet.stack.questions;

import java.util.*;

public class Q06_WaterTrapProblem {
    
    public static 
    void main(String args[]){
        int heights[] = {8, 8, 2, 4, 5, 5, 1};//{3,0,0,2,0,4,};
        System.out.println(Arrays.toString(heights));
        System.out.println(trappingWater(heights, heights.length));
    }

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        int maxL[] = new int[n], maxR[] = new int[n];
        int water[]=new int[n];
        int waterTrapped=0;
        maxL[0] = arr[0];
        maxR[n-1] = arr[n-1];
        for(int i=1; i<n;i++){
            maxL[i] = Math.max(arr[i],maxL[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            maxR[i] = Math.max(arr[i],maxR[i+1]);
        }
        // maxR[0] = Math.max(arr[0],maxR[1]);
        System.out.println(Arrays.toString(maxL));
        System.out.println(Arrays.toString(maxR));
        for(int i=0;i<n;i++){
            water[i]+=waterTrapped+=(Math.min(maxL[i],maxR[i]) - arr[i] );
        }
        // System.out.println(Arrays.toString(water));
        return waterTrapped;
    } 
}
