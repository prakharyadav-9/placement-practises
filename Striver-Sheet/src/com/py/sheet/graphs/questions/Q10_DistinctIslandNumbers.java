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
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1},
            // {1,1},
            // {0,1},
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
        Set<String> dfsSet = new HashSet<>();
        Set<String> bfsSet = new HashSet<>();
        int n= grid.length,m=grid[0].length,num=0;
        boolean vstd[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0&&!vstd[i][j]){
                    bfs(i,j,grid,vstd,bfsSet);
                    StringBuilder path = new StringBuilder();
                    dfs(i,j,i,j,grid,vstd,path);
                    // System.out.println(path.toString());
                    if(path.length()>0) dfsSet.add(path.toString());
                    num++;
                }
            }
        }
        // System.out.println("number of islands in grid = "+num);
        System.out.printf("through BFS = %d, DFS = %d\n",bfsSet.size(),dfsSet.size());
        // return bfsSet.size();
        return dfsSet.size();
    }

    private 
    void bfs(int sr,int sc,int grid[][],boolean vst[][],Set<String> s){
        vst[sr][sc]=true; // exploring but 
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
                    &&grid[nR][nC]==1&&vst[nR][nC]==false ){ 
                        vst[nR][nC] = true; // visted but not completely
                        q.offer(new Pair(nR,nC));
                        path.append(nR-sr).append(nC-sc);
                }
            }
            // vst[node.r][node.c]=2; // completely explored
        }
        // after complete exploration from the source node add the path to set
        // System.out.printf("explored path from {%d,%d} is %s\n",sr,sc,path.toString());
        s.add(path.toString());
    }
    private 
    void dfs(int baseRow,int baseCol,int currRow,int currCol,
                                    int grid[][],boolean vst[][],StringBuilder path){
        if(vst[currRow][currCol]==false){ // if passed node is not visited 
            vst[currRow][currCol]=true;
            System.out.printf("coordinate:: {%d,%d}",currRow,currCol);
            path.append(currRow-baseRow).append(currCol-baseCol); // adding to currPath
            int dirRow[]={-1,0,1,0},dirCol[]={0,1,0,-1}; // neighbour directions
            for(int dir=0;dir<4;dir++){ // exploring all four directions
                int nR=currRow+dirRow[dir],nC=currCol+dirCol[dir]; // neighbour row & col
                if(nR>=0&&nR<grid.length&&nC>=0&&nC<grid[0].length
                &&grid[nR][nC]==1&&vst[nR][nC]==false){
                    dfs(baseRow,baseCol,nR,nC,grid,vst,path); // exploring valid unexplored neighbours
                }
            }
        }
    }
}
