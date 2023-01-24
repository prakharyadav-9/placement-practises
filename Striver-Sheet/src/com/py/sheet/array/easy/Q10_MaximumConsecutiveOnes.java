package com.py.sheet.array.easy;

public class Q10_MaximumConsecutiveOnes {

	static int findZeroes(int arr[], int n, int m) {
        int j =-1;
        int max=0;
        int cnt =0;
        for(int i =0;i<n;i++){
            if(arr[i]==0)cnt++;
            //when number of zeroes is greater than k,remove 0
            while(cnt>m){
                j++;
                if(arr[j]==0)cnt--;
            }
            max = Math.max(max,(i-j));
        }
        return max;
    }
	public static void main(String[] args) {
		int arr[]= {1,0,1};//{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
		System.out.println(findZeroes(arr, arr.length, 1));
	}

}
