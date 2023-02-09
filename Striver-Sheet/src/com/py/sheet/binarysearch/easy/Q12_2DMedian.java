package com.py.sheet.binarysearch.easy;

public class Q12_2DMedian {

	static int median(int arr[][], int R, int C) {
        // code here
		int low = 1;
	    int high = 1000000000;
	    int n = R;
	    int m = C;
	    while (low <= high) {
	      int mid = (low + high) >> 1;
	      int cnt = 0;
	      for (int i = 0; i < n; i++) {
	        cnt += countSmallerThanEqualtoMid(arr[i], mid, C);
	      }
	      if (cnt <= (n * m) / 2)
	        low = mid + 1;
	      else
	        high = mid - 1;
	    }
	    return low;
	}
	
	private static int countSmallerThanEqualtoMid(int[] arr, int mid,int col) {
		 int l = 0, h = col - 1;
		    while (l <= h) {
		      int md = (l + h) >> 1;
		      if (arr[md] <= mid) {
		        l = md + 1;
		      } else {
		        h = md - 1;
		      }
		    }
		    return l;
	}

	public static void main(String[] args) {
		int arr[][]= {
				{1,3,5},
				{2,6,9},
				{3,6,9},
		};
		System.out.println(median(arr,arr.length,arr[0].length));

	}

}
