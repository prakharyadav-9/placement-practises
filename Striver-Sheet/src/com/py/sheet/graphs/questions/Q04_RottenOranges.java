package com.py.sheet.graphs.questions;

import java.util.LinkedList;
import java.util.Queue;

public class Q04_RottenOranges {
    private class Triplet{
        int row,col,rtnTm;
        Triplet(int row,int col, int tm){
            this.row=row;
            this.col = col;
            this.rtnTm=tm;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid) {
        // Code here
        int time=0;
        int n=grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<Triplet> queue = new LinkedList<>();
        // pushing all initial rotten oranges configuration 
        //and counting the fresh oranges
        int freshCnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.add(new Triplet(i,j,time));                    
                    visited[i][j]=true;
                }else if(grid[i][j]==1){
                    freshCnt+=1;
                }
            }
        }
        int dirRow[] = {-1,0,+1,0};// up, right
        int dirCol[] = {0,+1,0,-1};// down, left
        int cnt=0;
        while(queue.isEmpty()==false){
            // take the front of queue
            Triplet rotten = queue.poll(); 
            int row = rotten.row;
            int col = rotten.col;
            int rtnTm = rotten.rtnTm;
            // update the actual time 
            // if new rotten time is present in queue
            time=Math.max(time,rtnTm);
            // now check one level traversal form current 
            // rotten orange coordinates
            for(int i=0;i<4;i++){
                int nRow = row + dirRow[i];
                int nCol = col + dirCol[i];
                // check the rows and cols and its vist stats
                // and is a fresh orrange 
                if(nRow>=0&&nRow<n&&nCol>=0&&nCol<m&&
                !visited[nRow][nCol]&& grid[nRow][nCol]==1){
                    // then add the orrange into queue
                    // with time greater with 1 by prev rtnTm
                    queue.add(new Triplet(nRow,nCol,rtnTm+1));
                    visited[nRow][nCol]=true;
                    cnt++; // add the fresh->rotten
                }
            }
        }
        if(cnt!=freshCnt) return -1;       
        return time;
    }
}
