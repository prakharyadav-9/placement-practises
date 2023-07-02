package com.py.mocks.bits.codeforces;

import java.util.*;

public class Q03_TwoButtons{
    public static void main(String...args){
        try(Scanner sc = new Scanner(System.in)){
            int t= 1;//sc.nextInt();
            while(t-->0){
                int n = sc.nextInt(); // length of test secquence
                int m=sc.nextInt();
                long rmNum = minClicks(n,m);
                System.out.println(""+rmNum);
            }
    

        }
    }

    private static long minClicks(int n, int m) {
        if(n>=m)
            return Math.abs(n-m);
        int min=00;
        while(m>n){
            if(m%2!=0)  m+=1;
            else m/=2;
            min++;
        }
        return min+=(n-m);
    }    
}