package com.py.sheet.string.easy;

final class Q04_LongesCommonPrefix {

	/*
	 * Given a array of N strings, 
	 * find the longest common prefix among all strings present in the array.
	 */
	static 
	String longestCommonPrefix(String arr[], int n){
        // code here
		// find shortest string
		int idxShrt = 0;
		int shortLen = arr[idxShrt].length();
		for(int i=1;i<n;i++) {
			idxShrt = arr[i].length()<shortLen?i:idxShrt;
			shortLen = arr[idxShrt].length();
		}
		int lpm =0;
		for(int i=0;i<shortLen;i++) {
			boolean  matching = false;
			for(int j= 0; j<n;j++) {
				if(j==idxShrt) {
					continue;
				}else {
					if(arr[j].charAt(i) != arr[idxShrt].charAt(i)) {
						matching=true;
					}
				}
			}
			if(matching) {
				break;
			}
			lpm++;
		}
		return lpm==0?"-1":arr[idxShrt].substring(0, lpm);
    }
	
	/*
	 * gets the index of shortest string 
	 */
	static void shortestLenStr(String arr[]) {
		// find shortest string
		int idxShrt = 0;
		for(int i=1;i<arr.length;i++) {
			idxShrt = arr[i].length()<arr[idxShrt].length()?i:idxShrt;
		}
		System.out.println(idxShrt + " " + arr[idxShrt]);
	}
	
	public static void main(String[] args) {
		String arr[] = {"a"};// ,"abcd" ,"abcde", "abcdefg", "abcdef", "ab" ,"abcc" ,"abcdefgh" ,"abcdefghi"};//{"hello","hell"};//{"geeksforgeeks", "geeks", "geek","geezer"};
		System.out.println(longestCommonPrefix(arr, arr.length));
//		shortestLenStr(arr);
	}

}