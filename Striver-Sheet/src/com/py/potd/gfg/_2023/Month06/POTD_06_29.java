package com.py.potd.gfg._2023.Month06;

import java.util.*;

public class POTD_06_29 {
    public static
    void main(String args[]){
        int n=8;
        int happyNum = nextHappy(n);
        System.out.println(happyNum);

    }
    static Set<Integer> trueValues = new HashSet<>();
    static Set<Integer> falseValues = new HashSet<>();
    static int nextHappy(int n){
        // code here
        while(true){
            trueValues.addAll(Arrays.asList(1,7));
            falseValues.addAll(Arrays.asList(2,3,4,5,6,8,9));
            // we have to keep on checking which number is our next happy number
            n++; // checking from next number from given number
            if(isHappy(n)) // loop breaks when closest happoy number is found
            break;
        }
        return n;
    }
    private static
    boolean isHappy(int n){
        // checks whether its a happy number 
        if(trueValues.contains(n))  return true;
        else if(falseValues.contains(n))    return false;
        // when we find the sum neither in the sets 
        //so we have to go hard way and calculate the sum
        // and again pass this sum forward to recursive call
        int squarSum =0;
        while(n>0){
            int unitDigit = n%10;
            n/=10;
            squarSum +=unitDigit*unitDigit;
        }
        return isHappy(squarSum);
    }
}
