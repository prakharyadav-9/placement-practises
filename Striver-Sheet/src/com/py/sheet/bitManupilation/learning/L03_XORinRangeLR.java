package com.py.sheet.bitManupilation.learning;

public class L03_XORinRangeLR {
    
    /*
     * XOR in range [L R]
     */

    private static int xorTillN(int n){
        if(n%4==0)
            return n;
        if(n%4 == 1)
            return 1;
        if(n%4 == 2)
            return n+1;
        // this is for n%4 == 3
        return 0;
    }
    
    static int xorInRangeLR(int L,int R){
        return xorTillN(L-1)^xorTillN(R);
    }
    
    public static void main(String...args){
        int L=3;
        int R=6;
        System.out.printf("XOR between [%d %d] is %d",L,R,xorInRangeLR(L,R));
    }
}
