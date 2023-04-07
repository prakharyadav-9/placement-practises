package com.py.sheet.recursion.playlist;

import java.util.*;

public class V14_NQueen {
    /*
     * place the n queens in nxn chess board
     * with 3 rules:
     *  1. each columns has one queen
     *  2. each row has one queen
     *  3. no queen attack each other
     */

    private static class Checks{
        int size;
        boolean []row;
        boolean []upperDiagonal;
        boolean []lowerDiagonal;
        Checks(int n){
            this.size = n;
            this.row = new boolean[n];
            this.lowerDiagonal = new boolean[2*n-1];
            this.upperDiagonal  = new boolean[2*n-1];
        }
    } 
    static ArrayList<ArrayList<Integer>> nQueen(int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        char board [][] = new char[n][n];
        // System.out.println(" element "+ Arrays.toString(board[0])+ " !!" + (int)board[0][0]+ " .");
        Checks checks = new Checks(n);
        solve(0,board,new ArrayList<>(), ans,checks,n);
        return ans;
    }

    private static void solve(int column, char[][] board, ArrayList<Integer> config,ArrayList<ArrayList<Integer>> ans, Checks checks, int n) {
        // all queens are placed
        if(column == n){
            ans.add(new ArrayList<>(config));
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,column,checks,board,n)){
                board[row][column] = 'Q';
                checks.row[row] = true;
                checks.lowerDiagonal[row+column] = true;
                checks.upperDiagonal[n-1 +(column-row)] = true;
                config.add(column, row+1);
                solve(column+1, board, config, ans, checks, n);
                // back tracking
                config.remove(config.size()-1);
                board[row][column] = (char) 0;
                checks.row[row] = false;
                checks.lowerDiagonal[row+column] = false;
                checks.upperDiagonal[n-1 +(column-row)] = false;
            }
        }
    }

    private static boolean isSafe(int row, int column, Checks checks, char[][] board,int n) {
        if(checks.row[row]==false && checks.lowerDiagonal[row+column]==false && checks.upperDiagonal[n-1 +(column-row)]==false)
            return true;
        return false;
    }

    public static void main(String...args){
        int n=1;
        List ans = nQueen(n);
        System.out.println(ans);
        System.out.println(ans.size());
    }
}
