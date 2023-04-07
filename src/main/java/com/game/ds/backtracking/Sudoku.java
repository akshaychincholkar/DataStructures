package com.game.ds.backtracking;

public class Sudoku {
    public static void main(String[] args) {
        final int size = 9;
        if(!solveSodoku(size)) System.out.println("Cannot solve the Sudoku!");
    }

    private static boolean solveSodoku(int N) {
        int[][] grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        if(solve(grid,0,0,N)){
            printSudoku(grid,N);
            return true;
        }else{
            return false;
        }
    }


    private static boolean solve(int[][] grid, int row, int col, int N) {
        // check for the final condition of the recursion
        if(row == N-1 && col == N) return true;

        // Check for the row completion condition
        if(col == N){
            row++;
            col = 0;
        }

        // If number is already present condition
        if(grid[row][col] != 0) return solve(grid,row,col+1,N);

        // Actual logic
        for(int num = 0 ; num < 10 ; num++){
            if(isSafe(grid,row,col,N,num)){
                grid[row][col] = num;
                if(solve(grid,row,col+1,N))return true;
                grid[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] grid, int row, int col, int N, int num) {
        // check for the entire row
        for(int i = 0 ; i<N; i++){
            if(grid[row][i] == num) return false;
        }
        //check for the entire column
        for(int i = 0 ; i<N; i++){
            if(grid[i][col] == num) return false;
        }
        //check for the sub-array
//        int startRow = 3 * (row/3);
//        int startCol =3 * (col/3);
        int startRow = row - row%3;
        int startCol = col - col%3;
        for(int i=0 ;i<3 ;i++){
            for(int j=0; j<3; j++){
                if(grid[startRow+i][startCol+j] == num) return false;
            }
        }
        return true;
    }

    private static void printSudoku(int[][] grid, int N) {
        for(int i = 0 ; i<N ; i++){
            for(int j=0; j<N ; j++){
                System.out.print(grid[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
