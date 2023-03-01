package com.py.sheet.potd.gfg.Month02;

public class POTD_02_15 {

	static public void dfs(int row,int col,int[][] mat,int[] delrow,int[] delcol,int[][] visited){
        visited[row][col]=1;
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];      
            if(nrow>=0 && nrow<n &&ncol>=0 &&ncol<m
            		&& mat[nrow][ncol]>=mat[row][col] 
            				&& visited[nrow][ncol]==0){
                dfs(nrow,ncol,mat,delrow,delcol,visited);
            }
        }
    }

	static int water_flow(int [][] mat, int N, int M) {
		int[][] visited1=new int[N][M];
		int[][] visited2=new int[N][M];
		int[] delrow={-1,0,1,0};
	    int[] delcol={0,1,0,-1};    
	    for(int i=0;i<M;i++){
             dfs(0,i,mat,delrow,delcol,visited1);
             dfs(N-1,i,mat,delrow,delcol,visited2);
	    }
	    for(int i=0;i<N;i++){
         dfs(i,0,mat,delrow,delcol,visited1);
         dfs(i,M-1,mat,delrow,delcol,visited2);
	    }	
        int count=0;
        for(int i=0;i<N;i++){
         for(int j=0;j<M;j++){
             if(visited1[i][j]==visited2[i][j] &&visited1[i][j]==1)
             count++;
         }
        }
     return count;
	}         
	public static void main(String[] args) {

		int mat[][] =    {{1, 3, 3, 2, 4},
	               {4, 5, 6, 4, 4},
	               {2, 4, 5, 3, 1},
	               {6, 7, 1, 4, 5},
	               {6, 1, 1, 3, 4}};
		System.out.println(water_flow(mat, mat.length, mat[0].length));
	}

}
