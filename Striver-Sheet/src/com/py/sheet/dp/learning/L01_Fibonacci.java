package com.py.sheet.dp.learning;

public class L01_Fibonacci{
    /*
     * I will be following a pattern of all 3 solutions
     * given by striver
     * above main will be memoization + recurssion solution
     * 
     * below main will be the tabulation + space optimization
     */
    // private int fib(int n, int[] dp) {
    //     if(n==1||n==0){
    //         return dp[n];
    //     }
    //     if(dp[n]!=0) return dp[n];
    //     else dp[n]=fib(n-1,dp)+fib(n-2,dp);
    //     return dp[n];
    // }
    // int fibonacci(int n){
    //     int dp[]=new int[n+1];
    //     dp[1]=1; // initial configuration
    //     dp[n]= fib(n,dp);
    //     return dp[n];
    // }
    public static void main(String...args){
        int n=7;
        int fib=-1;
        L01_Fibonacci obj=new L01_Fibonacci();
        fib=obj.fibonacci(n);
        System.out.println(fib);
    }

    
    // private int fibonacci(int n) {
    //     int dp[]=new int [n+1];
    //     dp[1]=1;
    //     for(int i=2;i<=n;i++){
    //         dp[i]=dp[i-2]+dp[i-1];
    //     }
    //     return dp[n];
    // }
    
    /*
     * Most optimized 
     */
    private int fibonacci(int n) {
        int prev=1,prev2=0; // two previouses
        for(int i=2;i<=n;i++){
            int sum=prev+prev2; // compute the ith fibonacci
            prev2=prev; // shift the previouses
            prev=sum; // shifting
        }
        return prev; // the prev will be holding nth fibonacci
    }
}