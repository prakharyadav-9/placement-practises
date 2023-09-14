package com.py.sheet.bitManupilation;

import java.util.*;

public class Q03_PeterAndLock {
    public static void main(String []args){
        try(Scanner sc= new Scanner(System.in)){
            int n=sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            peterAndLock(arr);
        }
    }

    private static boolean found=false;
    private static void peterAndLock(int[] arr) {
        f(0,0,arr,false);
        if(found==false){
            System.out.println("NO");   
        }else{
            System.out.println("YES");
        }

    }
    static 
    void f(int idx,int currSum,int arr[],boolean fd){
        if(found==false){
            if(idx==arr.length){ // need to include all the numbers
                if(currSum==0){
                    // System.out.println("YES");
                    found=true;
                }
            }else{
                // all elements are not considered yet
                // taking positive
                f(idx+1,(currSum+arr[idx])%360,arr,fd);
                // taking negative
                f(idx+1,(currSum-arr[idx])%360,arr,fd);
            }
        }
        
    }
}
