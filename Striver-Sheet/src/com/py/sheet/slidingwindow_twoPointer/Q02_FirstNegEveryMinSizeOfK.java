package com.py.sheet.slidingwindow_twoPointer;
import java.util.*;
public class Q02_FirstNegEveryMinSizeOfK {
    public static void  
    main(String...args){
        long arr[] = {-8, 2, 3 ,-6 ,10};//{12,-1,-7,8,-15,30,16,28};
        int k=2;//3;
        System.out.println(Arrays.toString(arr));
        Q02_FirstNegEveryMinSizeOfK obj = new Q02_FirstNegEveryMinSizeOfK(); 
        long ans[] = obj.printFirstNegativeInteger(arr,arr.length,k);
        System.out.println(Arrays.toString(ans));
    }
    public long[] printFirstNegativeInteger(long A[], int N, int K){
        int high=0,low=0,ansIdx=0;
        Queue<Integer> negIdx = new LinkedList<>();
        long ans[] =new long[N-K+1];
        while(high<N){
            // check each number if it contributes to ans we need it
            if(A[high]<0) 
                    negIdx.offer(high); // store all negative to queue
            if(high-low+1==K){
                // window i formed & will continously be formed till end
                low++; // moving the window from low
                if(negIdx.isEmpty()){
                    ans[ansIdx++]=0;
                }else{
                    int topIdx=negIdx.peek();
                    ans[ansIdx++]=A[topIdx];
                    if(topIdx<low)  negIdx.poll();
                }
                high++; // from high
            }else{
                // window not ye formed
                high++;
            }
        }
        return ans;
    }
}
