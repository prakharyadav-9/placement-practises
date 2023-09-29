package com.py.tests.mocks.bits.codeforces;

import java.util.*;

public class Q01_RemovePrefix {
    public static void main(String...args){
        try(Scanner sc = new Scanner(System.in)){
            int t= sc.nextInt();
            while(t-->0){
                int n = sc.nextInt(); // length of test secquence
                int arr[]=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextInt();
                }
                int rmNum = removePrefix(arr);
                System.out.println(""+rmNum);
            }
    

        }
    }
    private static
    int removePrefix(int arr[]){
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for(int i=n-1;i>=0;i--){
            if(set.contains(arr[i])==false){
                set.add(arr[i]);
            }
            else{
                return i+1;
            }
        }
        return 0;
    }
}
