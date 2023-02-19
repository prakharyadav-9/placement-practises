package com.py.sheet.weeklycontest.gfg;

public class WC_02_19 {

	static
	public long totalSubarrays(long a[], int n, long x){
        // Code Here.
		long ans = 0l;
//		for(int i=0;i<n;i++) {
//			for(int j=i;j<n;j++) {
//				long andRes= a[j];
//				for(int k =i;k<=j;k++) {
//					andRes = (andRes & a[k]);
//				}
//				if(andRes == x)
//					ans++;
//			}
//		}
//		System.out.println(ans);
//		
		ans=0l;
		for(int i=0;i<n;i++) {
			long ansRes = a[i];
			if(a[i]<x)
				continue;
			for(int j=i;j<n;j++) {
				if((ansRes = (ansRes&a[j]))==x)
					ans++;
				if(a[j]<x) {
					break;
				}
			}
		}
		return ans;
    }   
	
	public static void main(String[] args) {
		long arr [] ={11,18,1,2};// {2,6,6,4};//{2,6,2};
		System.out.println(11&18);
		long x =2;
		printSubArray(arr,arr.length);
		System.out.println(totalSubarrays(arr, arr.length, x));
 	}
	
	static
	void printSubArray(long arr[],int n){
		int count=0;
		int x=2;
		//This loop will select start element
		for (int i=0; i <n; i++) { 
			long ansRes = arr[i];
			//This loop will select end element
			for (int j=i; j<n; j++) {
				if((ansRes=(ansRes& arr[j]))== x) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
