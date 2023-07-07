package com.py.potd.gfg._2023.Month07;

public class POTD_07_01 {
    public static void 
    main(String...args){
        int N=10;
        int bits=0;
        bits=setBits(N);
        System.out.println(bits);
    }
    static int setBits(int N) {
        // code here
        int stB=0;
        while(N!=0){
            int rem = N%2;
            N/=2;
            if(rem==1)
                stB++;
        }
        return stB;
    }
}
