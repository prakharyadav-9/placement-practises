package com.py.sheet.bitManupilation.learning;

public class L04_CheckEvenOdd {
    static
    boolean checkOddEven(int n){
        if((n&1) == 0)
            return true;
        else 
            return false;
    }
    public static void main(String...args){
        int n=-2;
        System.out.println(checkOddEven(n));
    }
}
