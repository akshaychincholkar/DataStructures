package com.game.ds;

import java.util.*;

public class Test {
    // Driver code
    public static void main(String args[]){
        int size = 4;
        if(!solveNQueen(size)) System.out.println("No formation found");
    }

    private static boolean solveNQueen(int N) {
        int[][] board = new int[N][N];

        if(solve(board,0,N)) {
            printBoard(board,N);
            return true;
        }else{
            return false;
        }
    }
    private static boolean solve(int[][] board, int col, int N) {
        if(col>=N) return true;
        for(int i=0;i<N;i++){
            if(isSafe(board,i,col,N)){
                board[i][col] = 1;
                if(solve(board,col+1,N)) return true;
                board[i][col] = 0; // backtracking
            }
        }
        return false;
    }
    private static void printBoard(int[][] board, int N) {
        for(int i = 0;i < N; i++){
            for(int j = 0; j<N ; j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }



    private static boolean isSafe(int[][] board, int row, int col, int N) {
        // check for left row
        for(int i=0;i<col;i++){
            if(board[row][i] == 1) return false;
        }
        //check for upper diagonal
        for(int i = row, j = col; i>=0 && j>=0;i--,j--){
            if(board[i][j] == 1) return false;
        }

        //check for lower diagonal
        for(int i = row,j=col;i<N && j>=0;i++,j--){
            if(board[i][j] == 1)return false;
        }
        return true;
    }

}
