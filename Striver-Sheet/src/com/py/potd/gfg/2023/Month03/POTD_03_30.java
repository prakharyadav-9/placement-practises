package com.py.sheet.potd.gfg.Month03;

public class POTD_03_30 {
    public static int minimumInteger(int N, int[] A) {
        // code here
        long sum = 0;
        for(int ele: A){
            sum+=ele;
        }
        int ans  = Integer.MAX_VALUE;
        for(int ele:A){
            if(sum <= (long)ele*N)
                ans = Math.min(ans, ele);
        }
        return ans;  
    }
    public static void main(String ...arg){
        int arr[] ={9 ,8 ,2,};// {3 ,4 ,6 ,3 ,10, 4 ,3, 8 ,10,};//{3,};//{1,3,2,};
        System.out.println(minimumInteger(arr.length, arr));
    }
}
