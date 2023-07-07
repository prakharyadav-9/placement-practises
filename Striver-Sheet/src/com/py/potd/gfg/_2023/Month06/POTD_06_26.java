package com.py.potd.gfg._2023.Month06;

public class POTD_06_26 {
    private static final int MOD = 1000000007;
    static int dp[][]  ;
    /*
     * Memoization solution
     */
    // static int nCr(int n, int r){
    //     // code here
    //     if(r>n) return 0;
    //     dp = new int[n+1][r+1];
    //     return solve(n,r,dp);
    // }
    
    // private static
    // int solve(int n,int r,int dp[][]){
    //     if(r==0|| n==r) return 1;
    //     if(dp[n][r]!=0) return dp[n][r];
    //     return dp[n][r] = (solve(n-1,r,dp)+solve(n-1,r-1,dp))%MOD;
    // }
    public static void main(String ...args){
        int n=6;
        int r=2;
        int ans = nCr(n,r);
        System.out.println(ans);
    }

    // /*
    //  * Tabulation Solution
    //  */
    // static int nCr(int n,int r){
    //     if(r>n) return 0;
    //     dp = new int[n+1][r+1];
    //     // dp initialization
    //     for(int i=0;i<n;i++){
    //         dp[i][0]=1;
    //         if(i<=r)    dp[i][i] =1;
    //     }
    //     // calculate dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=r;j++)
    //             dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%MOD;
    //     }
    //     return dp[n][r];
    // }

    /* 
     * space optimization with Tabulation
     */
    static
    int nCr(int n,int r){
        if(r>n) return 0;
        if(r==n)    return 1;
        int prev[] = new int[r+1];
        int curr[] = new int [r+1];
        prev[0] = curr[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=r;j++){
                curr[j] = (prev[j-1]+prev[j])%MOD;
            }
            for(int j=1;j<=r;j++)   prev[j] = curr[j];
        }
        return prev[r];
    }
}
