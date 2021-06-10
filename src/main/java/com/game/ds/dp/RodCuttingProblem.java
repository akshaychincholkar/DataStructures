package com.game.ds.dp;

public class RodCuttingProblem {
    static int[][] t;
    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int rod = 4;
        int maxProfit = getMaxProfit(rod,length,price,length.length);
        System.out.println("Maximum profit: "+maxProfit);

    }

    public static int getMaxProfit(int rod,int[] length, int[] price,  int targetLen) {
            t = new int[targetLen+1][rod+1];
            for(int i = 1;i<=targetLen;i++){
                for(int j=1;j<=rod;j++){
                    if(length[i-1]<=j){
                        t[i][j] = Math.max(price[i-1] + t[i][j-length[i-1]],t[i-1][j]);
                    }else{
                        t[i][j] = t[i-1][j];
                    }
                }
            }
            return t[targetLen][rod];
    }
}
