package com.py.sheet.dp.learning;
public class L04_FrogKJumps {
    public static void main(String[]args){
        int n=4,k=2;
        int height[] = {10,40,30,10};
        int ans=-1;
        ans = minimizeCost(n, k, height);
        System.out.println(ans);
    }
    public static int minimizeCost(int n, int k, int []height){
        // Write your code here.
        int dp[] = new int[n+1];
        for(int i=1;i<n;i++){
            int minCst = Integer.MAX_VALUE;
            for(int jmp=1;jmp<=k;jmp++){ 
                if(i-jmp>=0){ // jumpping all valid jmps
                    // previous jumps
                    int jmpEnergy = dp[i-jmp] + Math.abs(height[i-jmp]-height[i]);
                    minCst = Math.min(minCst,jmpEnergy); // store min Energy with jumps
                }
            }
            dp[i] = minCst; // store the min jmps from all k previous jumps
        }
        return dp[n-1]; // returns min energy with atmost k jumps till nth stair
    }
}
