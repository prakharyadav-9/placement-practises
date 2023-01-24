package com.py.sheet.sorting;

public class Q15_Max1Row {
	static int rowWithMax1s(int arr[][], int n, int m) {
        int row=-1,i;
        int max=0;
        for(i=0,row=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    int ones= (m-j);
                    if(ones>max){
                        max=ones;
                        row=i;
                    }
                    break;
                }
            }            
        }
        return row;
    }

	public static void main(String[] args) {
		int arr[][]= {{0, 1, 1, 1},
		           {0, 0, 1, 1},
		           {0, 0, 1, 1},
		           {0, 0, 0, 0}};
		
		System.out.println(rowWithMax1s(arr, arr.length, arr[0].length));
	}

}
