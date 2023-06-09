package com.py.sheet.stack.questions;
import java.io.*;
import java.util.*;

public class Q08_MinSumSubarray {
    //{ Driver Code Starts

        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int t;
            t = sc.nextInt();
            while (t-- > 0) {
    
                int N;
                N = sc.nextInt();
    
                int[] arr = new int[N];
                for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
    
                Solution obj = new Solution();
                int res = obj.sumSubarrayMins(N, arr);
    
                System.out.println(res);
            }
        }

}

// } Driver Code Ends


class Solution {
    final static long MOD = 1000000007L;
    public static 
    int sumSubarrayMins(int N, int[] arr) {
        // code here
        int ans =0;
        int NLSEs[] =  new int [N], NRSEs[] = new int[N];
        // for(int i=0; i<N;i++){
        //     NRSEs[i] = N-i-1;
        //     NLSEs[i] = i;
        // }
        Stack<Integer> st = new Stack<>(); // supporing stack to calculate NRGEs & NLGEs
        // for each elemenmt calculateing NLGEs & NRGEs
        for(int i=0;i<N;i++){
            while(st.isEmpty() == false && ( arr[i%N] < arr[st.peek()])){
                // NRSEs[st.peek()] = i-st.peek() -1;
                st.pop();
            } 
            NLSEs[i] = st.isEmpty()?i:i-st.peek()-1;
            st.push(i);
        }
        System.out.println(st);
        System.out.println("NLSEs :: "+Arrays.toString(NLSEs));
        st.clear();
        // System.out.println(st);
        // now calculating NRGEs
        for(int i=N-1; i>=0;i--){
            while(st.isEmpty() == false
                    && (arr[st.peek()] >= arr[i%N]) ){
                        // NLSEs[st.peek()] = st.peek() -i-1;  //  another way of calculating number of NRSE
                        st.pop(); 
                    } 
            NRSEs[i] = st.isEmpty() ?N-i-1:st.peek()-i-1;
            st.push(i);
        }
        // System.out.println(st);
        System.out.println(Arrays.toString(NRSEs));
        for(int i=0; i<N;i++){
            ans=(int)((ans + (arr[i]%MOD * ((NLSEs[i]%MOD)  +1 )*((NRSEs[i]%MOD) +1)))%MOD);
        }

        return ans;
    }
}
