package com.py.sheet.weeklycontest.gfg;

import java.util.HashSet;
import java.util.Set;

public class WC_03_12 {

	public static void main(String ...args) {
		int a[] = {4 ,2 ,6 ,3 ,6 ,4 ,3,};//{7 ,4 ,2 ,5 ,2 ,6,};//{1,1,1,1,1,};//{ 1,2,3,1,4,};
		int cap = 1;
		System.out.println(workDone(a.length,a,cap));
	}
	
	static
	public int workDone(int n, int a[], int cap){
        // Code Here. 
        int wd=0;
        int lastItem=0;
        Set<Integer> belt = new HashSet<>(cap);
//        Queue<Integer>  belt = new ArrayDeque<>();
        for(int i=0;i<a.length;i++){
            if(!belt.contains(a[i])){
                belt.add(a[lastItem=i]);
                wd++;
//                containing;
            if(belt.size()==cap){
                belt.remove(a[lastItem++]);
//                wd++;
                belt.add(a[i]);
            }
            }
        }
        return wd;
    }
}
