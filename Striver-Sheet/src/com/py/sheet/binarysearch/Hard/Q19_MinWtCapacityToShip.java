package com.py.sheet.binarysearch.Hard;

public class Q19_MinWtCapacityToShip {

	static int leastWeightCapacity(int[] arr, int N, int D) {
        // code here
		int ans=-1;
		int min = arr[0],sum=arr[0];
		for(int i=1;i<N;i++) {
			min = arr[i]<min?arr[i]:min;
			sum+=arr[i];
		}
		while(min<=sum) {
			int midWt = min + (sum-min)/2;
			if(isShippingPossible(arr,midWt,D)) {
				ans=midWt;
				sum=midWt-1;
			}else {
				min=midWt+1;
			}
		}
		return ans;
    }
	
	
	private static boolean isShippingPossible(int[] arr, int maxWt, int d) {
		int sum=0;
		for(int wt: arr) {
			sum+=wt;
			if(sum>maxWt) {
				d--;
				sum=wt;
			}
			if(d==0|| wt>maxWt)
				return false;
		}
		if(sum>maxWt) {
			return false;
		}
		return true;
	}


	public static void main(String[] args) {
		int arr[] = {12 ,20 ,3, 7, 12, 16, 1 ,18 ,13 ,11 ,14 ,15, 7 ,17 ,2,10};//{9,8,10};
		int D = 2;
		System.out.printf("Mininum capacity:: %d",leastWeightCapacity(arr, arr.length, D));

	}

}
