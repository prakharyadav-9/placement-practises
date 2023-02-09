package com.py.sheet.binarysearch.Hard;

public class Q17_MinDaystoMBouquotes {

	public static int solve(int m, int k, int[] arr) {
		// we require k*m flowers and if we dont have it in 
		// gardern no use of any operation
		if(m*k>arr.length)
			return -1;
		else {
			int ans=-1;
			int min=arr[0];
			for(int i=1;i<arr.length; i++) {
				min = min<arr[i]?min:arr[i];
			}
			int max=arr[0];
			for(int i=1;i<arr.length; i++) {
				max = max>arr[i]?max:arr[i];
			}
			/*
			 * our search space is our [minDays maxDays] 
			 */
			while(min<=max) {
				int mid= (min+max)/2;
				//use mid day and check if it satisfies the condition
				if(isPossible(arr,mid,k,m)) {
					/*
					 * if its possible
					 * firstly we store the answer
					 * then be a little greedy,
					 * we will reduce our search space
					 * by decreasing max
					 */
					ans=mid;
					max=mid-1;
				}else {
					/*
					 * then our mid makes bouquotes that are < m(required) in this days
					 * so lets reduces the search space by increasing the minimum days 
					 * may be we find our answer here after
					 */
					min = mid+1;
				}
			}
			return ans;
		}
    }
	
	private static boolean isPossible(int[] arr, int daysToWait, int k, int m) {
		int ans=0;
		int count =0;
		/*
		 * we check the possiblity by counting k consecutive days 
		 * if its <= daysToWait then that flower might have bloomed 
		 * if so then we can make a bouquote 
		 * 
		 *  we check for whole gardern
		 *  and if are able to make minimum @param m bouquotes then
		 *  @return true as possiblity
		 *  else false
		 */
		for(int i=0;i<arr.length;i++) {
			if(daysToWait>=arr[i]) {
				count++;
			}else {
				count=0;
			}
			if(count ==k) {
				ans++;
				count=0;
			}
		}
		return ans>=m;
	}

	public static void main(String[] args) {
		int arr[] = {1,10,3,10,2};//{5, 5, 5, 5, 10, 5, 5};//{1, 10, 3, 10, 2};
		int m= 3;
		int k= 1;
		System.out.println(solve(m,k,arr));

	}

}
