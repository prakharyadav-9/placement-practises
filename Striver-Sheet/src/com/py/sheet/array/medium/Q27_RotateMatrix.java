package com.py.sheet.array.medium;

public class Q27_RotateMatrix {

	static void print2D(int [][]arr) {
		for(int[] row:arr) {
			System.out.println();
			for(int ele:row) {
				System.out.print(ele + "   ");
			}
		}
	}
	
	//Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int arr[][], int n){ 
        // code here
    	for(int i=0;i<n/2;i++) {
    		for(int j=0;j<n;j++) {
    			int temp = arr[i][j];
    			arr[i][j] = arr[n-1-i][j];
    			arr[n-1-i][j]=temp;
    		}
    	}
    	for(int i=n-1,k=1;i>0;i--) {
    		int l=i-1;
    		for(int j=k;j<n;j++) {
    			int temp= arr[i][j];
//    			System.out.println("("+i+ ","+j+")->"+ "("+l+","+(k-1)+")");
    			arr[i][j] = arr[l][k-1];
    			arr[l][k-1] = temp;
    			l--;
    		}
    		k++;
    	}
    }
    
	public static void main(String[] args) {
		int arr[][]= {
				{1, 2, 3},
				{4, 5, 6},
	            {7, 8, 9},
//				{1,2,3,4},
//				{5,6,7,8},
//				{9,10,11,12},
//				{13,14,15,16},
					 };
		rotateby90(arr,arr.length);
		print2D(arr);
		
		}
	}

