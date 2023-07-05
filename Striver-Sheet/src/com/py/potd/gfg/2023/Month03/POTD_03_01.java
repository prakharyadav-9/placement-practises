package com.py.sheet.potd.gfg.Month03;

public class POTD_03_01 {

/*
 * Submitted	
 */
//	int [] updateQuery(int N, int Q, int [][]U){
//		int temp[][] = new int[N + 1][32];
//		for(int q[] : U) {
//	        int l = q[0] - 1;
//	        int r = q[1];
//	        int num = q[2];
//	        int index = 0;
//	        while(num > 0) {
//	            temp[l][index] += num % 2;
//	            temp[r][index] += -(num % 2);
//	            num = num / 2;
//	            index++;
//	        }
//	    }
//	    for(int i = 1; i <= N; i++) {
//	        for(int j = 0; j < 32; j++) {
//	            temp[i][j] += temp[i - 1][j];
//	        }
//	    }
//	    int ans[] = new int[N];
//	    for(int i = 0; i < N; i++) {
//	        int num = 0;
//	        for(int j = 0; j < 32; j++) {
//	            if(temp[i][j] != 0) {
//	                num |= (1 << j);
//	            }
//	        }
//	        ans[i] = num;
//	    }
//	    return ans;
//    }
	
	static
	int [] updateQuery(int N, int Q, int [][]U){
        //Write your code here
        int res [] = new int[3];
        for(int i=0;i<Q;i++){
            
        }
        System.out.println(10|0);
        return res;
    }
	
	public static void main(String[] args) {
//		int n = 3;
//		int q = 2;
		int u[][] = {
				{1, 3, 1},
				{1, 3, 2},
			};
		printl1D(updateQuery(u.length,u[0].length,u));

	}

	private static void printl1D(int[] updateQuery) {
		for(int ele: updateQuery) {
			System.out.printf("%d ",ele);
		}
		System.out.println();
		
	}

}
