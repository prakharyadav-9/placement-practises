package com.py.sheet.bitManupilation;

import java.util.*;

public class Q02_SingleNum_III {
    public int[] singleNumber(int[] nums) {
        int []ans=new int[2];
        int xor=0;
        for(int ele:nums) xor=xor^ele;
        int fstSetBit=0;
        while(xor!=0){
            if((xor&1)==1) break;
            fstSetBit++;
            xor=xor>>1;
        }
        int num=1<<fstSetBit;
        for(int ele:nums){
            if((num&ele)==0){
                ans[0]=ans[0]^ele;
            }else{
                ans[1]=ans[1]^ele;
            }
        }
        return ans;
    }

    public static void main(String[]args){
        Q02_SingleNum_III obj= new Q02_SingleNum_III();
        int arr[] = {1,2,1,3,2,5};
        int res[] = obj.singleNumber(arr);
        System.out.println(Arrays.toString(res));
    }
}
