package com.py.sheet.bitManupilation.learning;

public class L02_PrintXORTillN {
    /*
    * Given N print the XR till N
    * e.g.: N=5
    *  outPut = 1^2^3^4^5
    * using XOR in O(1)
    */
    static int xorTillN(int n){
        if(n%4==0)
            return n;
        if(n%4==1)
            return 1;
        if(n%4==2)
            return n+1;
        // below one gives answer for n%4 == 3
        return 0;
    }

    public static void main(String...args){
        int N=4;
        System.out.println(xorTillN(N));
        
    }
}
