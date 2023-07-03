package com.py.sheet.graphs.questions;

import java.util.LinkedList;
import java.util.Queue;

public class Q05_FloodFill {
    private class Coordinate{
        int row,col;
        Coordinate(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        // Code here 
        int n=image.length, m=image[0].length;
        // make a copy of original image
        int newImage[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                newImage[i][j] = image[i][j];
        }
        // vist signifies the  changed pixel stats
        boolean vist[][] = new boolean[n][m];
        // queue holding the coordinate pixel to update  
        Queue<Coordinate> queue= new LinkedList<>();
        queue.add(new Coordinate(sr,sc));
        int rowDir[] = {-1,0,+1,0},colDir[] = {0,+1,0,-1};
        vist[sr][sc] = true;
        // do bfs for only one level
        while(queue.isEmpty()==false){
            Coordinate coordinate = queue.poll();
            // set the pixel
            newImage[coordinate.row][coordinate.col]=newColor;
            // traversing across neighbours
            for(int i=0;i<4;i++){
                int nRow=coordinate.row+rowDir[i]; // neighbour row
                int nCol=coordinate.col+colDir[i]; // neighbour col
                if(nRow>=0&&nRow<n&&nCol>=0&&nCol<m&&
                    !vist[nRow][nCol]&&newImage[nRow][nCol]==image[sr][sc]){
                    vist[nRow][nCol]=true;
                    queue.add(new Coordinate(nRow,nCol));
                }
            }
        }
        return newImage;
    }
}
