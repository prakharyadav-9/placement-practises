package com.py.sheet.weeklycontest.gfg;

public class WC_07_09_Q1 {
    public static void 
    main(String...args){
        int arr[] = {1,0,1,1};
        int k=3;

        int boxes = minBoxes(arr,k);
        System.out.println(boxes);
    }

    private static int minBoxes(int[] arr, int k) {
        int w=0,b=0;
        for(int ele:arr){
            if(ele==0)  w++;
            else b++;
        }
        w = (int)(Math.ceil(1d*w/k));
        b = (int)(Math.ceil(1d*b/k));
        int boxes = w+b;
        return boxes;
    }
}
