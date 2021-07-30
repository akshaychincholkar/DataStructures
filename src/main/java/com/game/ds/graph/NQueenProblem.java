package com.game.ds.graph;

public class NQueenProblem {
    public static void main(String[] args) {
        int[][] a={{0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}};
        printMatrix(a);
        performNQueen(a,0);
        System.out.println("-------------------------------");
        printMatrix(a);
    }

    public static boolean performNQueen(int[][] a,int column) {
        if(column>=4)return true;
        for(int i=0;i<a.length;i++){
            if(placeQueenOrNot(a,i,column)){
                a[i][column] = 1;
                if(performNQueen(a,column+1))return true;
                a[i][column]=0;
            }
        }
        return false;
    }

    private static boolean placeQueenOrNot(int[][] a, int row, int column) {
        for(int i=0;i<=column;i++){
            if(a[row][i]==1)return false;
        }
        for(int i=row,j=column;i>=0 &&j>=0;i--,j--){
            if(a[i][j]==1)return false;
        }
        for(int i=row,j=column;i<a.length &&j>=0;i++,j--){
            if(a[i][j]==1)return false;
        }
        return true;
    }

    public static void printMatrix(int[][] a) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
