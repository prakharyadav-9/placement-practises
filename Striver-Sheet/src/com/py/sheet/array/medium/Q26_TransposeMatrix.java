package com.py.sheet.array.medium;

public class Q26_TransposeMatrix {

	static void print2D(int [][]arr) {
		for(int[] row:arr) {
			System.out.println();
			for(int ele:row) {
				System.out.print(ele + "   ");
			}
		}
	}
	
	//Function to find transpose of a matrix.
    static void transpose(int arr[][], int n){
        // code here
    	for(int i=0;i<n;i++) {
    		for(int j=i+1;j<n;j++) {
    			int temp = arr[i][j];
    			arr[i][j]= arr[j][i];
    			arr[j][i]=temp;
    		}
    	}
    	
    }
    
	public static void main(String[] args) {
		int arr[][]={
//				{1, 1, 1, 1},
//		        {2, 2, 2, 2},
//		        {3, 3, 3, 3},
//		        {4, 4, 4, 4},
				{1, 2},
				{-9, -2}
		           };

		transpose(arr,arr.length);
		print2D(arr);
	}

}
