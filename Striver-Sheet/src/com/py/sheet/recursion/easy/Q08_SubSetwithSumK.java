package com.py.sheet.recursion.easy;

import java.util.Arrays;

public class Q08_SubSetwithSumK {
    
    private static final int mod = 100000007;
    /*
     * My implementation TLEs some 
     */
    // static
	// public int perfectSum(int arr[],int n, int sum) { 
	//     // Your code goes here
    //     int count = 0;
    //     count = count(0,arr, sum);
    //     return count;
	// } 
    // static
    // int count(int idx, int arr[], int sum){
    //     if(sum==0){
    //         return 1;
    //     }
    //     // sum not possible do not check further and waste recurssion calls
    //     if(sum<0){
    //         return 0;
    //     }
    //     int pick =0;
    //     int notPick = 0;
    //     if(idx+1<=arr.length){
    //         pick+=count(idx+1, arr, sum-arr[idx]);
    //         notPick+=count(idx+1, arr, sum);
    //     }
    //     return (pick + notPick)%mod;
    // }

    public static void main(String ...args){
        int arr[]={1,0};//{2,3,5,6,8,10,};
        Arrays.sort(arr);
        int sum = 1;//10;
        System.out.println(perfectSum(arr, arr.length, sum));
    }

    /*
     * DP solution
     */
    static int perfectSum(int arr[] , int n, int sum){
        int dp[][] = new int[n][sum+1];
        for(int[] a:dp)
            Arrays.fill(a, -1);
        return findWaysUtil(n-1,arr,sum,dp);
    }

    private static int findWaysUtil(int idx, int [] arr, int target, int [][]dp){
        if(idx==0){
            if(target==0 && arr[idx]==0)
                return 2;   // target is also 0 and the element is also 0 
                            //so it doesn't make any diference if we add one more element
            if(target==0||target==arr[idx])
                return 1;
            return 0;
        }
        if(dp[idx][target]!=-1)
            return dp[idx][target];
        int notPick = findWaysUtil(idx-1, arr, target, dp);
        int pick=0;
        // only take when next imediate element is okay to pick, should be less than equal to this target
        if(arr[idx]<=target)
            pick = findWaysUtil(idx-1, arr, target-arr[idx], dp);

        return dp[idx][target] = (pick+notPick)%(int)(Math.pow(10,9)+7);
    }
 
    /*
     * TABULATION
     */
    // public int perfectSum(int arr[],int n, int sum){ 
	//     int dp[][]=new int[n][sum+1];
	//     if(arr[0]==0)
	//      dp[0][0]=2;
	//     else{
	//     dp[0][0]=1;
	//     if(sum>=arr[0])
	//       dp[0][arr[0]]=1;
	//     }
	//       for(int i=1;i<n;i++){
	//           for(int t=0;t<=sum;t++){
    //               int notTaken =dp[i-1][t];
    //               int taken = 0;
    //                 if(arr[i]<=t)
    //                     taken = dp[i-1][t-arr[i]];
    //               dp[i][t]= (notTaken + taken)%(int)(Math.pow(10,9)+7);
	//           }
	//       }
	//    return dp[n-1][sum];
	//    } 

    /*
     * SPACE OPTIMIZATION
     */
    // public int perfectSum(int arr[],int n, int sum){ 
	//     int dp[]=new int[sum+1];
	//     int prev[]=new int[sum+1];
	//     if(arr[0]==0)
	//       prev[0]=2;
	//     else{
	//       prev[0]=1;
	//     if(sum>=arr[0])
	//       prev[arr[0]]=1;
	//     }
	//       for(int i=1;i<n;i++){
	//           for(int t=0;t<=sum;t++){
    //               int notTaken =prev[t];
    //               int taken = 0;
    //               if(arr[i]<=t)
    //                 taken =prev[t-arr[i]];
    //               dp[t]= (notTaken + taken)%(int)(Math.pow(10,9)+7);
	//           }
	//           prev=dp.clone();
	//       }
	//    return prev[sum];
	//    } 
}
