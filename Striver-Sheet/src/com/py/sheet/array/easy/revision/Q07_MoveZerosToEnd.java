package com.py.sheet.array.easy.revision;

import java.util.Arrays;

public class Q07_MoveZerosToEnd {
    
    public static void main(String[] args) {
		int a[] = {1,0,1};//{0,1,0,3,12};//{0,0,0,0,0,1,2,3,4,5,6};//{0,0,0,0,3,0,1,0,2,0};//2,3};//{1,1,2};//{1,1,2};//{1,3,4,5,6,12,17,19,28,28};//{2,20,20,40,60};//{3,5,10,10,10,15,15,20};
        Q07_MoveZerosToEnd obj = new Q07_MoveZerosToEnd();
		obj.moveZeroes(a);
		System.out.print(Arrays.toString(a));
	}

    public void moveZeroes(int[] nums) {
        int slow=0;
        int fast=1;
        while(fast<nums.length){
            if(nums[slow]==0&&nums[fast]!=0){
                // swap(nums,slow++,fast);
                nums[slow]+=(nums[fast]);
                nums[fast]=nums[slow]-nums[fast];
                nums[slow]-=nums[fast];
            }else if(nums[slow]!=-0&&nums[fast]!=0||
                                    (nums[fast]==0&&nums[slow]!=0)){
                slow++;
            }
            fast++;
        }
    }
    private void swap(int arr[],int srcIdx,int destIdx){
        arr[srcIdx]+=(arr[destIdx]);
        arr[destIdx]=arr[srcIdx]-arr[destIdx];
        arr[srcIdx]-=arr[destIdx];
    }
}
