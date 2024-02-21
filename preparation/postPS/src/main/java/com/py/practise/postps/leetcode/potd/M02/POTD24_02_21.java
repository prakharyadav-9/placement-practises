package com.py.practise.postps.leetcode.potd.M02;

public class POTD24_02_21{
    /*
    *   URL: https://leetcode.com/problems/bitwise-and-of-numbers-range/submissions/ 
    *   givrn range [left right] find the bitwise AND of all the numbers inclusive boundaries
    */
    public int rangeBitwiseAnd(int left, int right) {
        int shifts =0;
        while(left<right){
            left>>= 1;
            right >>= 1;
            shifts++;
        }
        return left<<shifts;            
    }
}