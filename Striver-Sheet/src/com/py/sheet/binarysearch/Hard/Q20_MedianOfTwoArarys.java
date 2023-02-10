package com.py.sheet.binarysearch.Hard;

import java.util.Arrays;

public class Q20_MedianOfTwoArarys {

	static double medianOfArrays(int n, int m, int a[], int b[]) {
        // Your Code Here
		
		// Firstly I will device the search space
		int arrMin[] = n<m?a:b;
		int arrMax[] = (arrMin!=a)?a:b;
		int minPartition  = 0, maxPartition= arrMin.length;
		
		// once partition space is determined use BS
		// to get the correct partition out of the all possible partitions
		// its great that both arrays are sorted so that we can use BS 
		int cutBase = (m+n+1)/2;
		while(minPartition<=maxPartition) {
			int meanPartition=minPartition + (maxPartition-minPartition)/2;
			// meanPartition determines our cut1
			int cut2= cutBase -meanPartition;
			int l1= (meanPartition>0)?arrMin[meanPartition-1]:Integer.MIN_VALUE;
			int l2=(cut2>0)?arrMax[cut2-1]:Integer.MIN_VALUE;
			// these are our last elements in the cuts 1 and 2
			int r1=(meanPartition<arrMin.length)?arrMin[meanPartition]:Integer.MAX_VALUE; 
			int r2=(cut2<arrMax.length)?arrMax[cut2]:Integer.MAX_VALUE;
			// these are our first elements to cuts 1 and 2
			
			if(l1<=r2 && l2<=r1) {
				// when we reached correct partition
				// we have two conditions 
				if((m+n)%2 ==0) {
					double res= Math.max(l1,l2)+Math.min(r1,r2);
					return res/2.0;
				}else
					return Math.max(l1,l2);// + ((m+n)%2==0?Math.max(r1,r2):0);
			}else
			if(l1<r2 == false) {
				maxPartition=meanPartition-1;
			}else if(l2<r1 == false) {
				minPartition=meanPartition +1;
			}
		}
		
		return 0;
    }
	
	public static void main(String[] args) {
		int arr1[]= {4}//{4,6}//{1,3}//{7,12,14,15,16}// {1,5,9}//
				,arr2[] = {1,3,4,6,7};//{1,2,3,5};// {2};//{1,2,3,4,9,11};//{2,3,6,7};//
		System.out.printf("Median of two arrays:: %f",
				medianOfArrays(arr1.length, arr2.length, arr1, arr2) );
	}

}
