package com.py.sheet.stack.questions;
import java.util.*;
public class Q05_NRGEsCount {
    /*
        URL -> <a href='https://tutorialcup.com/interview/stack/number-of-nges-to-the-right.htm'> Algorithm SOurce Article</a>
    */    
    public static 
    void main(String...args){
        int arr[] = {3, 4, 2, 7, 5, 8, 10, 6,};
        int []indicies = {0,7};
        System.out.println(Arrays.toString(arr));
        int ans[] = count_NGEs(arr.length, arr,indicies.length, indicies);
        System.out.printf(Arrays.toString(ans));
        System.out.println();
    }

    // private static
    // int[] allRightGreaterCounts(int arr[],int N){
    //     int dp[] = new int [N];
    //     dp[N-1] = 0;
    //     int next[] = new int[N]; 
    //     // each index specifies how which is index of nex elemeent that is greater than current idx
    //     Stack<Integer> st = new Stack <>();
    //     st.push(0);
    //     for(int i= 1;i< N;i++){
    //         while(st.isEmpty() == false){
    //             if(arr[st.peek()]<arr[i]){
    //                 next[st.pop()] = i;
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //         st.push(i); // pushing current idx
    //     }
    //     // preparing next[]
    //     while(st.isEmpty() == false){
    //         next[st.pop()] = -1;
    //     }
    //     System.out.println("next "+ Arrays.toString(next));
    //     // now calculating the number of NextRGE of each element
    //     for(int i=N-2;i>=0;i--){
    //         dp[i] = (next[i]==-1)? 0:(dp[next[i]] +1);
    //     } 
    //     return dp;
    // }
    // public static 
    // int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    //     int res[] = new int[queries];
    //     int allRightGreatestCounts[] = allRightGreaterCounts(arr, N);
    //     int idx=0;
    //     System.out.println(Arrays.toString(allRightGreatestCounts));
    //     for(int index:indices){
    //         res[idx++] = allRightGreatestCounts[index]; 
    //     }
    //     return res;
    // }
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        // code here
        int res[] = new int[queries];
        for(int queryIdx = 0;queryIdx <queries;queryIdx++){
            for(int i = indices[queryIdx]; i<N;i++){
                if(arr[indices[queryIdx]] < arr[i])
                    res[queryIdx] +=1; 
            }
            // System.out.println(Arrays.toString(res));
        }
        return res;
      }

}
