package com.py.sheet.graphs.questions;

import com.py.util.Util;
import java.util.*;

public class Q10_NumberOfIsland_1 {
    /*
     * this problem needs to be addressed first before
     * going to number of distinct island
     */
    public static void 
    main(String...args){
        char grid[][] = {
            // {'0','1'},{'1','0'},{'1','1'},{'1','0'},
            {'0','1','1','1','0','0','0'},{'0','0','1','1','0','1','0'},
        };
        Q10_NumberOfIsland_1  obj = new Q10_NumberOfIsland_1();
        Util.print2D(grid);
        int num = obj.numIslands(grid);
        System.out.println(num);

    }
    private class Pair{
        int r,c;
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int num=0;
        int n=grid.length;
        int m = grid[0].length;
        boolean vist[][] = new boolean[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]!='0'&&!vist[i][j])
                    bfs(i,j,grid,vist);
                    num++;
        return num;
    }
    private void bfs(int sr,int sc,char[][] grid, boolean[][] vist) {
        Queue<Pair> q= new LinkedList<>() ;
        q.offer( new Pair(sr,sc)); // starting from source
        vist[sr][sc] = true; // making source as marked
        int dirR[] = {-1,-1,0,1,1,1,0,-1}; // row directions
        int dirC[] = {0,1,1,1,0,-1,-1,-1}; // col directions
        while(q.isEmpty() == false){
            Pair node = q.poll();
            // now explore node's neighbours
            for(int i=0;i<8;i++){
                // neighbour row and column
                int nR=node.r+dirR[i],nC=node.c+dirC[i];
                if(nR>=0&&nR<grid.length&&nC>=0&&nC<grid[0].length
                    &&grid[nR][nC]=='1'&&!vist[nR][nC]){
                        // valid Land neighbour and is not visited
                        vist[nR][nC] = true; // mark as visited
                        q.offer(new Pair(nR,nC)); // add to queue
                }
            }
        }
    }
}
