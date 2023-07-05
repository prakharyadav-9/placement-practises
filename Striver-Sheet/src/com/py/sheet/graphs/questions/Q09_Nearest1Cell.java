package com.py.sheet.graphs.questions;

import java.util.*;
import com.py.util.Util;

public class Q09_Nearest1Cell{

    public static void
    main(String args[]){
        int grid[][]= {
            // {0,1,1,0},{1,1,0,0},{0,0,1,1},
            {1,0,1},{1,1,0},{1,0,0},
        };
        Util.print2D(grid);
        Q09_Nearest1Cell obj = new Q09_Nearest1Cell();
        int nearOneCell[][] = obj.nearest(grid);
        System.out.println();
        Util.print2D(nearOneCell);
    }
    private class Triplet{
        int r,c,step;
        Triplet(int r,int c,int step){
            this.r=r;
            this.c=c;
            this.step=step;
        }
    }
    public int[][] nearest(int[][] grid){
        // Code here
        int result[][] = new int[grid.length][grid[0].length];
        boolean visted[][] = new  boolean[grid.length][grid[0].length];
        Queue<Triplet> q = new LinkedList<>();
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    q.offer(new Triplet(i,j,0)); // add it to queue
                    visted[i][j]=true; // mark it visited
                }
            }
        }
        int dirRow[] = {-1,0,+1,0};
        int dirCol[] = {0,+1,0,-1};
        // now our inital configuration is done 
        while(q.isEmpty()==false){
            Triplet node = q.poll();
            // take out the front
            result[node.r][node.c] = node.step;
            // mark distance in result
            // visted[node.r][node.c] = true;
            // now do the BFS in for of its direction
            for(int i=0;i<4;i++){
                int nR = node.r+dirRow[i];
                int nC = node.c+dirCol[i];
                if(nR>=0&&nR<grid.length&& nC>=0&&nC<grid[0].length
                                                &&!visted[nR][nC]){
                    // if its not visited
                    q.offer(new Triplet(nR,nC,node.step+1));
                    visted[nR][nC]=true;
                }
            }
        }
        return result;
    }
}