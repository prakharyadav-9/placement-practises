package dsa.com.py.Blind75.T_01Arrays;

import java.util.Arrays;

public class Q_004ProductOfArrayExceptItself {

    public static void main(String args[]){
        int input[] = {
            // 1,2,3,4
            -1,1,0,-3,3

        };
        Q_004ProductOfArrayExceptItself outerObj = new Q_004ProductOfArrayExceptItself();

        Solution obj = outerObj.new Solution();
        System.out.println(Arrays.toString(obj.productExceptSelf(input)));
    }
    

    class Solution {
    public int[] productExceptSelf(int[] nums) {
        // approach come from left and come from right and product both of them
        int []left2Right = new int[nums.length];
        int []right2Left = new int[nums.length];

        // calculate left2Right starting from 2nd element, except itself
        left2Right[0] = right2Left[nums.length-1] = 1;
        for(int i=1; i<nums.length; i++){
            left2Right[i]= left2Right[i-1] * nums[i-1];
            right2Left[nums.length-1-i] = right2Left[nums.length-i] * nums[nums.length-i];
        }
        for(int i=0; i<nums.length; i++){
            left2Right[i] = left2Right[i] * right2Left[i];
        }
        return left2Right;
    }
}
}
