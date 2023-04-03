package com.py.sheet.weeklycontest.gfg;

public class GFG_WC_03_26 {

	static
	int vowlesCount(String word){
        int vowels = 0;
        int len = word.length();
        for(int i=0;i<len; i++){
            char ch = word.charAt(i);
            if(ch=='a' || ch=='e' ||
            ch=='i' || ch=='o' ||
            ch=='u')
                vowels++;
        }
        return vowels;
    }
	static
    public String valuableString(String arr[], int n){
        // Code Here
        int idx=0;
        int pdiff=0;
        for(int i=n-1 ; i>=0;i--){
            int vowels = vowlesCount(arr[i]);
            int consonents= arr[i].length()-vowels;
            int curr;
            pdiff = Math.max(pdiff,curr=Math.abs(vowels-consonents));
            if(curr==pdiff)
            	idx=i;
        }
        return arr[idx];
    }
	public static void main(String[] args) {
		String arr[]= {"house","car","tree"};
		System.out.println(valuableString(arr,arr.length));

	}

}
