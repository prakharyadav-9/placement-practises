package com.py.sheet.slidingwindow_twoPointer;

import java.util.HashMap;
import java.util.Map;

public class Q10_FruitIntoBasket {
    public static void
    main(String...args){
        int arr[] ={17,20,22,14};//{2,2,2,2,2,2,2};//{0, 1, 2, 2, 2, 2};//{2, 1, 2};
        int collected=-1;
        collected = totalFruits(arr.length,arr);
        System.out.println(collected);
    }
    public static int totalFruits(int N, int[] fruits) {
        int max=0;
        int b1=-1,b2=-1; // inital baskets no fruitTypes
        int cnt1=0,cnt2=0; // count number of each type fruits
        int low=0,high=0;// two pointers identifying subarray
        while(low<N&&high<N){
            if(b1==-1||fruits[high]==b1){
            // if b1 Empty or current high is at fruit of b1
            // consider it and increment the type
                b1=fruits[high];
                cnt1++;
                high++; // only increase high when new fruit or repeating fruit
            }else if(b2==-1||fruits[high]==b2){
                // same if its of b2 type or we've empty bw
                b2=fruits[high];
                cnt2++;
                high++; // rule of high
            }else{
                // 3rd new different type of fruit encountered
                // calculate the current subarray
                max=Math.max(max,high-low);
                // empty either of bag ang
                while(low<N&&b1!=-1 && b2!=-1){
                    if( fruits[low]==b1){
                        // remove from bag 1
                        cnt1--;
                        if(cnt1==0) 
                            b1=-1;
                    }else if(fruits[low]==b2){
                        // rremove from bag 2
                        cnt2--;
                        if(cnt2==0)
                            b2=-1;
                    }
                    low++;
                }
            }
        }
        return Math.max(max,high-low);
    }
}
