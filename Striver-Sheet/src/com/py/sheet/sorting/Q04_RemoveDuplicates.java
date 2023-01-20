package com.py.sheet.sorting;

import java.util.Arrays;

public class Q04_RemoveDuplicates {

	static int remove_duplicate(int A[],int N){
        // code here
//		for(int i=0;i<N-1;i++) {
//			if(A[i]!= A[i+1]) {
////				i++;
////				j++;
//				A[j++]= A[i];
//			}
////			else {
////				i++;
//////				A[++j]= A[i++];
////			}
//		}
		if(A.length ==0 || A.length==1) {
			return A.length;
		}
		int j=0;
		for(int i=1;i<A.length;) {
			if(A[i] == A[j]) {
				i++;
			}else{
				A[j+1]= A[i];
				j++;
			}
		}
		return  j+1;
    }
	public static void main(String[] args) {
		int a[] = {1,1,2};//{1,1,2};//{1,3,4,5,6,12,17,19,28,28};//{2,20,20,40,60};//{3,5,10,10,10,15,15,20};
		/*
		 * 42
		 * 1 3 4 5 6 12 13 17 19 22 23 25 27 28 28 35 36 37 39 43 46 48 54 59 62 63 65 68 68 70 70 72 79 82 83 92 92 93 95 96 96 100
		 */
		int eles=remove_duplicate(a,a.length);
		System.out.println(eles + " "+ Arrays.toString(a));
	}

}
