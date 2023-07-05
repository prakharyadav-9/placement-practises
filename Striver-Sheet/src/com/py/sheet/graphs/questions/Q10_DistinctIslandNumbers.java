package com.py.sheet.graphs.questions;

import java.util.*;
import com.py.util.Util;

public class Q10_DistinctIslandNumbers {
    public static void
    main(String...args){
        int grid[][]= {
            // {1, 1, 0, 0, 0},
            // {1, 1, 0, 0, 0},
            // {0, 0, 0, 1, 1},
            // {0, 0, 0, 1, 1},
            // {1, 1, 0, 1, 1},
            // {1, 0, 0, 0, 0},
            // {0, 0, 0, 0, 1},
            // {1, 1, 0, 1, 1},
            {1,1},
            {0,1},
        };
        Q10_DistinctIslandNumbers obj =  new Q10_DistinctIslandNumbers();
        Util.print2D(grid);
        int islands = obj.countDistinctIslands(grid);
        System.out.print(islands);
    }
    private class Pair{
        int r,c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        Set<String> s = new HashSet<>();
        int n= grid.length,m=grid[0].length,num=0;
        int vstd[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0&&vstd[i][j]!=2){
                    bfs(i,j,grid,vstd,s);
                    num++;
                }
            }
        }
        // System.out.println("number of islands in grid = "+num);
        return s.size();
    }

    private 
    void bfs(int sr,int sc,int grid[][],int vst[][],Set<String> s){
        vst[sr][sc]=1; // exploring but 
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc));
        StringBuilder path = new StringBuilder(grid.length*grid[0].length);
        path.append(sr-sr).append(sc-sc);
        int dirRow[]={-1,0,1,0},dirCol[]={0,1,0,-1};
        while(!q.isEmpty()){
            Pair node = q.poll();
            // explore its neighbours
            for(int dir=0;dir<4;dir++){
                int nR=node.r+dirRow[dir],nC=node.c+dirCol[dir];
                if(nR>=0&&nR<grid.length&&nC>=0&&nC<grid[0].length
                    &&grid[nR][nC]==1&&vst[nR][nC]==0 ){//(vst[nR][nC]!=2 || vst[nR][nC]!=1)){ // node is not touched 
                        vst[nR][nC] = 1; // visted but not completely
                        q.offer(new Pair(nR,nC));
                        path.append(nR-sr).append(nC-sc);
                }
            }
            vst[node.r][node.c]=2; // completely explored
        }
        // after complete exploration from the source node add the path to set
        // System.out.printf("explored path from {%d,%d} is %s\n",sr,sc,path.toString());
        s.add(path.toString());
    }
}
