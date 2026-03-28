package dsa.com.py.Blind75.T_08Matrix;

public class Q_04_WordSearch {
    /*
    Question Link: https://leetcode.com/problems/word-search/

    [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
"ABCCED"
[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
"SEE"
[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
"ABCB"
    */

class Solution {
    private int rows;
    private int cols;
    private boolean visited[][];

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[this.rows][this.cols];

        boolean exist = false;
        for(int i=0; i<rows; i++){
            for(int j =0; j<cols; j++){
                // up, down, left and right
                exist = dfs(board, i,j, word, 0);
                if(exist){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char [][]board, int rowIdx, int colIdx, String word, int strIdx){
        if(strIdx>=word.length()){ return true; } 
        if(rowIdx<0 || rowIdx>=(rows) || colIdx<0 || colIdx>= cols){ return false; }
        if(visited[rowIdx][colIdx]){ return false; } 
        if(word.charAt(strIdx) != board[rowIdx][colIdx]){ return false; } 

        visited[rowIdx][colIdx] = true; // valid node at valid strIdx 
        boolean up    = dfs(board, rowIdx-1, colIdx, word, strIdx+1);
        boolean down  = dfs(board, rowIdx+1, colIdx, word, strIdx+1);
        boolean left  = dfs(board, rowIdx, colIdx-1, word, strIdx+1);
        boolean right = dfs(board, rowIdx, colIdx+1, word, strIdx+1);
        visited[rowIdx][colIdx] = false; // back tracking resset the visit
        return up || down || left || right;
    }
}
}
