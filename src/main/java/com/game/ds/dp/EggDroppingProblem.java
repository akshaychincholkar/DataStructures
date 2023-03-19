package com.game.ds.dp;

import java.util.Arrays;

public class EggDroppingProblem {
    private static int[][] t ;
    public static void main(String[] args) {
        int e = 2;
        int f = 6;
        int n = getMinNumberOfMoves(e,f);
        System.out.println("Recursive: "+n);

        t = new int[e+1][f+1];
        for(int[] array:t) Arrays.fill(array,-1);
        System.out.println("Memoization:"+getMinNumberOfMovesMemoization(e,f));

        for(int[] array:t) Arrays.fill(array,-1);
        System.out.println("Top Down:"+getMinNumberOfMovesTopDown(e,f));
        }
    private static int getMinNumberOfMoves(int e, int f) {
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;
        int min = Integer.MAX_VALUE;
        for(int k=1; k<=f ; k++){
            int temp = 1 + Math.max(getMinNumberOfMoves(e-1,k-1),getMinNumberOfMoves(e,f-k));
            min = Math.min(min,temp);
        }
        return  min;
    }
    private static int getMinNumberOfMovesMemoization(int e, int f) {
        if(f==0 || f == 1) return f;
        if(e == 1) return f;
        if(t[e][f]!= -1) return t[e][f];

        int min = Integer.MAX_VALUE;
        for(int k =1;k<=f;k++){
            int temp = 1 + Math.max(getMinNumberOfMovesMemoization(e-1,k-1),
                    getMinNumberOfMovesMemoization(e,f-k));
            min = Math.min(min,temp);
        }
        return t[e][f] = min;
    }

    private static int getMinNumberOfMovesTopDown(int e, int f) {
        if(f==0 || f == 1) return f;
        if(e == 1) return f;
        if(t[e][f]!= -1) return t[e][f];

        int min = Integer.MAX_VALUE;
        for(int k =1;k<=f;k++){
            int low;
            if(t[e-1][k-1] != -1){
                low = t[e-1][k-1];
            }else{
                low = getMinNumberOfMovesTopDown(e-1,k-1);
            }
            int high;
            if(t[e][f-k] != -1){
                high = t[e][f-k];
            }else{
                high = getMinNumberOfMovesTopDown(e,f-k);
            }
            int temp = 1 + Math.max( low, high);
            min = Math.min(min,temp);
        }
        return t[e][f] = min;
    }
}
