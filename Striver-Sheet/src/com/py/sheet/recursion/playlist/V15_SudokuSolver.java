package com.py.sheet.recursion.playlist;

import java.util.*;

public class V15_SudokuSolver{


    private static final int N=9;
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][]){
        // add your code here
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                // traversing the matrix
                if(grid[i][j]==0){
                    // this space needs to be filled
                    for(int k=1;k<=N;k++){
                        // check everyNumber 1 t0 9
                        if(isValid(grid,i,j,k)){
                            grid[i][j]=k;
                            if(SolveSudoku(grid)==true)
                                return true;
                            else
                                grid[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValid(int[][] grid, int row, int col, int item) {
        for(int i=0; i<N;i++){
            if(grid[row][i]==item)
                return false;
            if(grid[i][col]==item) return false;
            /* block checking */
            if(grid[3*(row/3)+ i/3][3*(col/3)+i%3] == item)
                return false;
        }
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][]){
        // add your code here
        for(int row[]: grid){
            for(int element:row ){
                System.out.print(element+ " " );
            }
            System.out.println();
        }
    }


    public static void main(String ...args){
        int grid[][]={
            {3, 0 ,6 ,5 ,0 ,8, 4, 0, 0},
            {5 ,2, 0, 0, 0, 0, 0, 0, 0},
            {0 ,8 ,7 ,0 ,0 ,0 ,0 ,3 ,1},
            {0 ,0 ,3 ,0 ,1 ,0 ,0 ,8 ,0},
            {9 ,0 ,0 ,8 ,6 ,3 ,0 ,0, 5},
            {0 ,5 ,0 ,0 ,9 ,0, 6, 0, 0},
            {1 ,3 ,0 ,0 ,0 ,0 ,2 ,5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if(SolveSudoku(grid))
            printGrid(grid);
        else
            System.out.print("Not solveable");

    }
}