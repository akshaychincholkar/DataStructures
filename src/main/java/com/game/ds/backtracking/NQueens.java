package com.game.ds.backtracking;

public class NQueens {
    public static void main(String[] args) {
        int size = 4;
        solveNQueensProblem(size);
    }

    private static void solveNQueensProblem(int size) {
        int[][] board = new int[size][size];
        if(!solve(board,0,size)) {
            System.out.println("No formation found");
        }else{
            printBoard(board);
        }
    }
    private static boolean solve(int[][] board, int col,int n) {
        if(col>= n) return true;
        for(int i = 0; i< n ; i++){
            if(isSafe(board,i,col,n)){
                board[i][col] = 1;
                if(solve(board,col+1,n)) return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col,int n) {
        for(int i=0;i<col;i++){
            if(board[row][i] == 1) return false;
        }
        for(int i=row,j=col;i>=0 && j>=0; i--,j--){
            if(board[i][j]==1) return false;
        }
        for(int i=row,j=col;i<n && j>=0; i++,j--){
            if(board[i][j]==1) return false;
        }
        return true;
    }
    private static void printBoard(int[][] board) {
        for(int[] array:board){
            for(int element: array){
                System.out.print("  "+element);
            }
            System.out.println();
        }
    }
}
