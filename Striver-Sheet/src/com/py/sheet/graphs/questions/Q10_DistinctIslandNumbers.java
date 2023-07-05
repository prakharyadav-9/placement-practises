package com.py.sheet.graphs.questions;

import java.util.*;

public class Q10_DistinctIslandNumbers {
    public static void
    main(String...args){
        int grid[][]= {

        };
        Q10_DistinctIslandNumbers obj =  new Q10_DistinctIslandNumbers();
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
        Set<Integer> s = new HashSet<>();
        int n= grid.length,m=grid[0].length;
        int vstd[][]=new int[n][m];
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[n][m]==1){
                    q.offer(new Pair(i,j));
                    vstd[n][m] = 1;
                }
            }
        }
        int sum=0;
        int dirR[] = {-1,0,+1,0}, dirC[] = {0,+1,0,-1};
        while(q.isEmpty()==false){
            Pair node = q.poll();
            if(vstd[node.r][node.c]!=2){
                
                for(int i=0;i<4;i++){
                    int nR = dirR[i],nC=dirC[i];
                    if(nR>=0&&nR<n&&nC>=0&&nC<m
                                && vstd[nR][nC]!=2){
                        vstd[nR][nC]=2;
                        q.offer(new Pair(nR,nC));
                    }
                }
            }
        }
        return s.size();
    }
}
