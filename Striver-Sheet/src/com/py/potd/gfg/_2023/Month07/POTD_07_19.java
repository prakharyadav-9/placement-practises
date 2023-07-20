package com.py.potd.gfg._2023.Month07;

public class POTD_07_19 {
    public static void main(String...args){
        String s="bbabcbcab";// 7//
        POTD_07_19 obj=new POTD_07_19();
        int longest= obj.longestPalinSubseq(s);
        System.out.println(longest);
    }
    public int longestPalinSubseq(String S){
        int n = S.length();
        int dp[][] = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                   dp[i][j] = S.charAt(i)==S.charAt(j)? 2:1;
                }
                else{
                    if(S.charAt(i)==S.charAt(j)){
                        dp[i][j] = 2 +  dp[i+1][j-1];
                    }
                    else{
                        dp[i][j] =  Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
