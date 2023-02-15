package com.py.sheet.binarysearch.Hard;

class Q22_AllocateMinPages {

	 public static int findPages(int[]A,int N,int M){
	    //Your code here
		int res=-1;
		if(M>N)
			return res;
		long low =Integer.MAX_VALUE;
		long high = 0;
		for(int ele: A) {
			high+=ele;
			low = low>ele?ele:low;
		}
		while(low<=high) {
			long maxPages = low + (high-low)/2;
			if(isAllocationPossble(A,maxPages,M)) {
				high = maxPages -1;
				res = (int) maxPages;
			}else {
				low = maxPages +1;
			}
		}
		return (int)res; 
	 }
	 
	private static boolean isAllocationPossble(int[] arr, long pages, int m) {

		int cnt = 0;
        int sumAllocated = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sumAllocated + arr[i] > pages) {
                cnt++;
                sumAllocated = arr[i];
                if (sumAllocated > pages) return false;
            } else {
                sumAllocated += arr[i];
            }
        }
        if (cnt < m) return true;
        return false;
//		int allocated = 1,pageI=0;
//		for(int i=0;i<arr.length;i++) {
//			if(arr[i]>pages)
//				return false;
//			if(pageI + arr[i]> pages) {
//				allocated+=1;
//				pageI +=arr[i];
//			}
//			else {
//				pageI+=arr[i];
//			}
//				
//		}
//		long individualPages = 0;
//		for(int i=0;i<arr.length;i++) {
//			individualPages +=arr[i];
//			if(individualPages>pages) {
//				individualPages=arr[i];
//				m--;
//			}
//				
//		}
//		if(m<0)
//			return false;
//		return true;
	}

	public static void main(String[] args) {
		int arr[] = {13,31,37,45,46,54,55,63,73,84,85};//{15,17,20};//{12,34,67,90};//
		int M = 9;//2;//2;//
		System.out.println(findPages(arr,arr.length,M));

	}

};
