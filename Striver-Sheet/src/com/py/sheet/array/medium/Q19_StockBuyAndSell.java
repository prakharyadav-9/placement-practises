package com.py.sheet.array.medium;

public class Q19_StockBuyAndSell {

	/*
	 * get the maximum profit out of the prices 
	 */
	static public int maxProfit(int[] prices) {
		int iniVal=prices[0],max=0;
		for(int i=1;i<prices.length;i++) {
			if(prices[i] <iniVal) {
				iniVal=prices[i];
			}
			int curProf=prices[i]-iniVal;
			if(max<curProf) {
				max=curProf;
			}
		}			
     
		return max;
    }
	public static void main(String[] args) {
		int arr[]= {3,2,6,5,0,3};//{7,1,5,3,6,4};
		System.out.println(maxProfit(arr));

	}

}
