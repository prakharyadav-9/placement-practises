package com.py.potd.gfg._2023.Month07;

public class POTD_07_05 {
    /*
     * URL: https://practice.geeksforgeeks.org/problems/stock-buy-and-sell2615/1
     * The cost of stock on each day is given in an array price[] of size n. 
     * Each day you may decide to either buy or sell the stock i at price[i],
     *  you can even buy and sell the stock on the same day,
     *  Find the maximum profit which you can get.
     */
    public static void
    main(String...args){
        int arr[] = {3, 4, 1, 5};
        int profit = stockBuyAndSell(arr.length, arr);
        System.out.println(profit);
    }
    /*
     * solution is buting and selling the stocks for each consicutive day if the 
     * we are gaining some profit
     */
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        int profit = 0;
        for(int i=1;i<n;i++){
            if((prices[i] - prices[i-1]) > 0)
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}
