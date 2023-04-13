package com.py.sheet.bitManupilation.learning;

public class L05_COuntSetBits {
    
    private static 
    int unsetTheSetBit(int n){
        return n&(n-1);
    }

    static
    int countSetBits(int n){
        int bits=0;
        while(n!=0){
            // unset the LS Set BIT
            n= unsetTheSetBit(n);
            bits++;
        }
        return bits;
    }

    public static void main(String...aargs){
        int n=3;
        int setBits=countSetBits(n);
        System.out.println(setBits);
    }
}
