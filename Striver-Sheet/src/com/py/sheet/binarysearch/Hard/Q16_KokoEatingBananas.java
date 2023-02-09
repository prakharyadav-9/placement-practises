package com.py.sheet.binarysearch.Hard;

public class Q16_KokoEatingBananas {

	public static int Solve(int N, int[] arr, int H) {
        // code here
		int max  = arr[0];
		for(int i=1;i<N;i++) {
			max = max>arr[i]?max:arr[i];
		}
		if(N==H) {
			return max;
		}else { // means H>N
			int l=1;//N;
			int h=max;
			int ans=h;
			while(l<=h) {
				int mid= l + (h-l)/2;
				if(checkSpeed(mid,arr)<=H) {
					ans=mid;
					h=mid-1;
				}else {
					l=mid+1;
				}
			}
			
			return ans;
		}
    }
	
	
	private static int checkSpeed(int speed, int[] arr) {
		int ans=0;
		for(int ele:arr) {
			ans+= Math.ceil(ele*1.0/speed);
		}
		return ans;
	}


	public static void main(String[] args) {
		int arr[] = {10,11,8,4,9,16, 5, 3, 5, 4, 13, 14,
				2, 7, 2, 9 ,3, 11, 17, 5, 12, 19, 4, 15, 7, 1, 17, 5,
				1,17,2,7,8,10,10,13,6,11,15,8,14,5,18,12};//{30,11,23,4,20};//{3, 6, 7, 11};// {30, 11, 23, 4, 20};
		System.out.println(arr.length);
		int H = 45;//5;
		System.out.println(Solve(arr.length,arr,H));
	}

}
