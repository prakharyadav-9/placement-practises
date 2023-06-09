package com.py.sheet.stack.questions;

import java.util.*;

public class Q09_RangesSumSubarray {
    
    public static void main(String args[]){
        int arr[]= {1,2,3};
        System.out.printf("Original :: %s\n",Arrays.toString(arr));
        System.out.println(subarrayRanges(arr.length, arr));
    }

    private static 
    int [] getNLS(int arr[]){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && (arr[i]< arr[st.peek()])){
                st.pop();
            }
            res[i] = st.isEmpty()? //i
                    -1
                    : st.peek();
            st.push(i);
        }
        return res;
    }
    private static 
    int[] getNRS(int [] arr){
        int n= arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&& (arr[i]<=arr[st.peek()]))   st.pop();
            res[i] = st.isEmpty()?//n-i-1
                        n
                        :st.peek();
            st.push(i);
        }

        return res;
        }
    public static 
    long subarrayRanges(int N, int[] arr) {
        // code here
        int nls[] = getNLS(arr);
        int nrs[] = getNRS(arr);
        int nlg[] = getNLG(arr);
        int nrg[] = getNRG(arr);
        System.out.printf("NLGs:: %s \n",Arrays.toString(nlg));
        System.out.printf("NRGs:: %s \n",Arrays.toString(nrg));
        System.out.printf("NLSs:: %s \n",Arrays.toString(nls));
        System.out.printf("NRSs:: %s \n",Arrays.toString(nrs));
        // now calculating range sum
        long sum = 0l;
        for(int i=0;i< N;i++){
            long lSmaller  =  i-nls[i];
            long rSmaller = nrs[i] - i;
            long lGreater = i- nlg[i];
            long rGreater = nrg[i] -i;
            long totalSum = ((lGreater*rGreater)-(lSmaller*rSmaller))*arr[i];
            sum+=totalSum;
        }
        return sum;
    }
    // gets the number of smaller elements till nearest right greatest
    private static int[] getNRG(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st =  new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && (arr[i] >= arr[st.peek()])){
                st.pop();
            }  
            res[i] = st.isEmpty()? //n-i-1
                    n
                    : st.peek();
            st.push(i);
        }
        return res;
    }

    private static int[] getNLG(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && (arr[i]> arr[st.peek()] ))   st.pop();
            res[i] = st.isEmpty()? //i
                    -1
                    : st.peek();
            st.push(i);
        }
        return res;
    }
}
