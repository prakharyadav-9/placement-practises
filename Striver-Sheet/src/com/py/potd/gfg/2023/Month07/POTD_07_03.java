package com.py.sheet.potd.gfg.Month07;

import java.util.Arrays;

public class POTD_07_03 {
    
    public static void 
    main(String...args){
        int arr[] ={18, 17};// {34, 8, 10, 3, 2, 80, 30, 33, 1};//
        POTD_07_03 obj = new POTD_07_03();
        int dif = obj.maxIndexDiff(arr, arr.length);
        System.out.println(dif);
    }
    int maxIndexDiff(int arr[], int n) {
        // code here
        int maxDiff=0;
        int min[] = new int[n];
        int max[] = new int[n];
        min[0] = 0;
        max[n-1] = n-1;
        for(int i=1;i<n;i++){
            min[i]=arr[min[i-1]]<arr[i]?min[i-1]:i;// Math.min(min[i-1],arr[i]);
            max[n-1-i]= arr[max[n-i]]>arr[n-1-i]?max[n-i]:n-1-i;//Math.max(max[n-i],arr[n-1-i]);
        }
        // System.out.println(Arrays.toString(min));
        // System.out.println(Arrays.toString(max));
        int i=0,j=0;
        while(i<n-1 &&j<n){
            // j=i+1;
            while(j<n&&arr[min[i]]<=arr[max[j]]){
                j++;
            }
            maxDiff = Math.max(maxDiff,j-1-i);
            i++;
        }
        return maxDiff;
    }
}
