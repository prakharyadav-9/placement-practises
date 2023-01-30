package com.py.sheet.array.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q25_MakeZeros {

	static void print2D(int [][]arr) {
		for(int[] row:arr) {
			System.out.println();
			for(int ele:row) {
				System.out.print(ele + "   ");
			}
		}
	}
	/*
	 * Given a matrix of  size n x m. 
	 * Your task is to make Zeroes, that means in whole matrix when you find a zero, 
	 * convert its upper, lower, left, and right value to zero 
	 * and make that element the sum of the upper, lower, left and right value. 
	 * Do the following tasks according to the initial matrix.
	 */
	static public void  MakeZeros(int[][] arr){
        // code here
		Map<Integer, List<Integer>> idx=new HashMap<>();
		int target [][] = new int[arr.length][arr[0].length];
		for (int row=0;row< arr.length;row++) {
			List<Integer> colss = new ArrayList<>();
			for(int col=0; col<arr[row].length;col++) {
				if(arr[row][col]==0) {
					colss.add(col);
					idx.put(row,colss);
				}
			}
		}
		for(int row=0;row<arr.length;row++) {
			for(int col=0;col<arr[row].length;col++) {
				target[row][col]=arr[row][col];
			}
		}
		for(Integer row: idx.keySet()) {
			int uR=row-1,uRE=0,dR=row+1,dRE=0;
			for(int lcc: idx.get(row)) {
				int lc=lcc-1,lce=0, rc=lcc+1,rce=0;
				int  coll= lcc;
				if(uR>=0) {
					uRE=arr[uR][coll];
					target[uR][coll] = 0;
				}
				if(dR<arr.length) {
					dRE= arr[dR][coll];
					target[dR][coll]=0;
				}
				if(lc>=0) {
					lce=arr[row][lc];
					target[row][lc]=0;
				}
				if(rc<arr[row].length) {
					rce=arr[row][rc];
					target[row][rc]=0;
				}
				target[row][lcc] = uRE+dRE+lce+rce;
			}
		} // after this just copy the temporary Matrix in to the original
		for (int row=0;row< arr.length;row++) {
			for(int col=0; col<arr[row].length;col++) {
				arr[row][col]=target[row][col];
			}
		}
		
    }
	public static void main(String[] args) {
		int arr[][]= {
				 {0,16 ,0 ,9 ,6 ,18},
				 {4 ,4 ,7 ,8 ,8 ,0},
				 {11, 4 ,17 ,12 ,0 ,18},
				 {6 ,14 ,12 ,12 ,4 ,3},
//				{0, 17, 9, 9, 13},
//				{18 ,1 ,15 ,2 ,3},
//				{4 ,10 ,19, 6 ,0},
				
//				{1, 2, 3, 4},
//                {5, 6, 0, 7}, 
//                {8, 9, 4, 6},
//                {8, 4, 5, 2}
		};
		
		print2D(arr);
		System.out.println();
		MakeZeros(arr);
		print2D(arr);
		

	}

}
