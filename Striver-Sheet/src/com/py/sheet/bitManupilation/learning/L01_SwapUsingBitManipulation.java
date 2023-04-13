package com.py.sheet.bitManupilation.learning;

public class L01_SwapUsingBitManipulation {
    
    public static void main(String...args){
        int a=5, b=7;
        System.out.printf("a = %d, b=%d\n",a,b);
        a=a^b;
        b=b^a;
        a=a^b;
        System.out.printf("a = %d, b=%d\n",a,b);
    }
}
