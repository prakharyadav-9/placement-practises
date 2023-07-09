package com.py.sheet.array.easy.revision;

import java.util.*;

public class R04_RemoveDuplicates {
    	public static void main(String[] args) {
		int a[] = {0,0,1,1,1,2,2,3,3,4};//{1,1,2};//{1,1,2};//{1,3,4,5,6,12,17,19,28,28};//{2,20,20,40,60};//{3,5,10,10,10,15,15,20};
		/*
		 * 42
		 * 1 3 4 5 6 12 13 17 19 22 23 25 27 28 28 35 36 37 39 43 46 48 54 59 62 63 65 68 68 70 70 72 79 82 83 92 92 93 95 96 96 100
		 */
        R04_RemoveDuplicates obj = new R04_RemoveDuplicates();
		int eles=obj.removeDuplicates(a);
		System.out.println(eles + " "+ Arrays.toString(a));
	}
     public int removeDuplicates(int[] nums) {
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(q.isEmpty()) q.offer(nums[i]);
            if(!q.isEmpty()&&((LinkedList<Integer>) q).peekLast()!=nums[i]) 
                q.offer(nums[i]);
        }
        int k=q.size();
        int i=0;
        while(!q.isEmpty()){
            nums[i++]=q.poll();
        }
        return k;
    }
}
