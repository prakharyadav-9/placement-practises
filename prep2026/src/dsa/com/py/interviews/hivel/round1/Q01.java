package dsa.com.py.interviews.hivel.round1;


import java.util.Arrays;

/*

"Given an array of integers representing 'transaction latencies' and a window size k, find the maximum latency for each sliding window of size k as it moves from the start to the end of the array."
Example: Input: nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
Output: [3, 3, 5, 5, 6, 7]


-----

Duplicate Values
[1, 3, 1, 2, 0, 5]
3
[3, 3, 2, 5]
Tests if the Deque correctly handles multiple occurrences of the maximum value. 

Single Element Window
[4, -2, 7]
1
[4, -2, 7]
When $k=1$, the output must be identical to the input array. 

Large Negative Values
[-7, -8, -7, 5, 7, 1, 6, 0]
4
[5, 7, 7, 7, 7]
Tests handling of negative latencies and large jumps in values
*/
public class Q01 {

    public static void main(String args[]){
        int [] inpt={
            1, 3, -1, -3, 5, 3, 6, 7
        };
        int k=3;

        int ans[] = getMaxLatencies(inpt, k);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] getMaxLatencies(int [] inp, int k){
        int n = inp.length; 
        int outSz = n-k+1;
        int res[] = new int [outSz];

        for(int i =0; i<n-k+1;i++){
            int currMax = Integer.MIN_VALUE;
            for(int j =i; j< i+k; j++){
                currMax = Math.max(currMax, inp[j]);
            }
            // will have the max in the window
            res[i]=currMax;
        }
        return res;

    }


    
}
