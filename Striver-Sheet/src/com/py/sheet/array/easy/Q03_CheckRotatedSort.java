package com.py.sheet.array.easy;

public class Q03_CheckRotatedSort {


	public static boolean check(int[] nums) {
		/*
		 * below logic would work for all conditions except all elements are same 
		 */
		boolean rotated=false;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>nums[(i+1)%nums.length]) {//&& (rotated = !rotated)) {
				rotated = !rotated;
			}
		}
        return rotated;
//		int count = 0;
//		for(int i = 0; i< nums.length ; i++){
//			if(nums[i] > nums[(i+1) % nums.length]){
//				count++;
//			}
//		}
//
//		if(count > 1) 
//			return false;
//		return true;
    }
	public static void main(String[] args) {
		int array[] = {2,3,4,5};//{1,2,3,4,5};//{3,4,5,1,2,3,0,3};//{10,7,6,5,3,9,2,1,8,4};
		System.out.println(check(array));
	}

}
